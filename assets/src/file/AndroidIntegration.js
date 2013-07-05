/*
 * Copyright (c) 2012 Adobe Systems Incorporated. All rights reserved.
 *  
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 *  
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *  
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 * 
 */


/*jslint vars: true, plusplus: true, devel: true, nomen: true, indent: 4, maxerr: 50 */
/*global define, brackets, Dropbox */
define(function (require, exports, module) {
    "use strict";

 
    
    function mapError(error) {
       
            return brackets.fs.NO_ERROR;
       
    }
    
    function readdir(path, callback) {
       // client.readdir(path, function (error, entries) {
        //    callback(mapError(error), entries);
		//	console.log(entries);
       // });
       
       var entries = [];
       entries = Android.ListFiles(path);
       if (entries != ""){
       entries = entries.split(",");
       } else {
       entries = [];
       }
       callback(brackets.fs.NO_ERROR,entries);
		
    }
    
    function makedir(path, mode, callback) {
       // client.mkdir(path, function (error) {
       //     callback(mapError(error));
       // });
       Android.CreateDirectory(path);
       callback(brackets.fs.NO_ERROR);
    }
    
    function stat(path, callback) {
       // client.stat(path, function (error, data) {
         //   callback(mapError(error), {
          //      isFile: function () {
           //         return data.isFile;
           //     },
           //     isDirectory: function () {
          //          return data.isFolder;
           //     },
          //      mtime: data && data.modifiedAt
          //  });
      //  });
      
      var result = Android.Stat(path);
      var error = brackets.fs.NO_ERROR;
      if (result == "ERROR"){
      error = brackets.fs.ERR_NOT_FOUND;
      }
      result = result.split(":");
      var isf = false;
      var isd = false;
      var modtime = parseInt(result[2]);
      if (result[0] == "true"){
      isf = true;
      } else {
      isf = false;
      }
      
       if (result[1] == "true"){
      isd = true;
      } else {
      isd = false;
      }
      
      callback(error, {
           isFile: function () {
                    return isf;
                },
                isDirectory: function () {
                    return isd;
                },
                mtime: modtime
            });
    }
    
    function readFile(path, encoding, callback) {
      //  client.readFile(path, function (error, data) {
		//console.log(data);
       //     callback(mapError(error), data);
			
       // });
       var data = Android.ReadFile(path);
       callback(brackets.fs.NO_ERROR, data);
    }
    
    function writeFile(path, data, encoding, callback) {
      //  client.writeFile(path, data, function (error) {
      //      callback(mapError(error));
      //  });
      Android.WriteFile(path,data);
      callback(brackets.fs.NO_ERROR);
    }
    
    function rename(oldPath, newPath, callback) {
       // client.move(oldPath, newPath, function (error) {
       //     callback(mapError(error));
       // });
       Android.Rename(oldPath,newPath);
       callback(brackets.fs.NO_ERROR);
    }
    
    function showOpenDialog(allowMultipleSelection, chooseDirectory, title, initialPath, fileTypes, callback) {
        alert("File/directory chooser not implemented yet");
        if (chooseDirectory) {
            callback(0, "/");
        } else {
            callback(1);
        }
    }
    
    function init() {
        
        brackets.fs = {};
        brackets.fs.readdir = readdir;
        brackets.fs.makedir = makedir;
        brackets.fs.stat = stat;
        brackets.fs.readFile = readFile;
        brackets.fs.writeFile = writeFile;
        brackets.fs.rename = rename;
        brackets.fs.showOpenDialog = showOpenDialog;
        
        // Error codes
        brackets.fs.NO_ERROR                    = 0;
        brackets.fs.ERR_UNKNOWN                 = 1;
        brackets.fs.ERR_INVALID_PARAMS          = 2;
        brackets.fs.ERR_NOT_FOUND               = 3;
        brackets.fs.ERR_CANT_READ               = 4;
        brackets.fs.ERR_UNSUPPORTED_ENCODING    = 5;
        brackets.fs.ERR_CANT_WRITE              = 6;
        brackets.fs.ERR_OUT_OF_SPACE            = 7;
        brackets.fs.ERR_NOT_FILE                = 8;
        brackets.fs.ERR_NOT_DIRECTORY           = 9;
        brackets.fs.ERR_FILE_EXISTS             = 10;
    }
    
    exports.init = init;
});
