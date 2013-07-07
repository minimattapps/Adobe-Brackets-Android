package com.adobe.brackets;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class CustomWebChromeClient extends WebChromeClient
{
    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String mesg = consoleMessage.sourceId() + ":"
                + consoleMessage.lineNumber() + ":"
                + consoleMessage.message();
        Log.i("JSCONSOLE", mesg);
        return true;
    }
}
