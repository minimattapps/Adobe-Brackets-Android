Welcome to Brackets! [![Build Status](https://travis-ci.org/adobe/brackets.png?branch=master)](https://travis-ci.org/adobe/brackets)
-------------------

Installers for the latest build can be [downloaded here](http://download.brackets.io/).

This is an early version of Brackets, a code editor for HTML, CSS
and JavaScript that's *built* in HTML, CSS and JavaScript. 

What makes Brackets different from other web code editors?

* **Tools shouldn't get in your way.** Instead of cluttering up your coding
environment with lots of panels and icons, the Quick Edit UI in Brackets puts 
context-specific code and tools inline.
* **Brackets is in sync with your browser.** With Live Development, Brackets
works directly with your browser to push code edits instantly and jump
back and forth between your real source code and the browser view.
* **Do it yourself.** Because Brackets is open source, and built with HTML, CSS
and JavaScript, you can help build the best code editor for the web.

You can see some 
[screenshots of Brackets](https://github.com/adobe/brackets/wiki/Brackets-Screenshots)
on the wiki and [intro videos](http://www.youtube.com/user/CodeBrackets) on the Brackets YouTube channel.

Brackets is fairly early in development, so some of the features you would
expect in a code editor are missing, and some existing features might be
incomplete or not as useful as you'd want. But if you like the direction
it's going, _there are lots of ways you can help._ See [CONTRIBUTING.md](https://github.com/adobe/brackets/blob/master/CONTRIBUTING.md)
for more info. Please contribute!

The text editor inside Brackets is based on 
[CodeMirror](http://github.com/marijnh/CodeMirror)&mdash;thanks to Marijn for
taking our pull requests, implementing feature requests and fixing bugs! See 
[Notes on CodeMirror](https://github.com/adobe/brackets/wiki/Notes-on-CodeMirror)
for info on how we're using CodeMirror.

How to run Brackets
-------------------

**Brackets isn't ready for general use yet.** It's still missing a lot of basic
editor features. That said, what's there is reasonably stable&mdash;the
Brackets team uses Brackets to develop Brackets full time. So feel free to
give it a spin and let us know what's missing!

Although Brackets is built in HTML/CSS/JS, it currently runs as a desktop 
application in a thin native shell, so that it can access your local files.
(If you just try to open the index.html file in a browser, it won't work yet.)
The native shell for Brackets lives in a separate repo, 
[adobe/brackets-shell](https://github.com/adobe/brackets-shell/).

The Brackets native shell currently runs on Mac and Windows.
The community has started working on a Linux port, and is making great progress;
if you're interested, check out the
[Linux Version](https://github.com/adobe/brackets/wiki/Linux-Version) wiki page.

You can download stable builds of Brackets from 
[download.brackets.io](http://download.brackets.io). If you want to pull the repo 
directly via git, see [How to Hack on Brackets](https://github.com/adobe/brackets/wiki/How-to-Hack-on-Brackets)
for instructions on how to get everything. 

By default, Brackets opens a folder containing some simple "Getting Started" content.
You can choose a different folder to edit using *File > Open Folder*. (Might we
suggest editing the Brackets source code and submitting some pull requests?)

Most of Brackets should be pretty self-explanatory, but for information on how
to use its unique features, like Quick Edit and Live Development, please read
[How to Use Brackets](http://github.com/adobe/brackets/wiki/How-to-Use-Brackets). 
The [extensions wiki page](https://github.com/adobe/brackets/wiki/Brackets-Extensions) 
has a list of extensions that have been contributed. 
Also, see the [release notes](http://github.com/adobe/brackets/wiki/Release-Notes)
for a list of new features and known issues in each build.

I found a bug/missing feature!
------------------------------

Issues starting Brackets the first time? Please review [Troubleshooting](https://github.com/adobe/brackets/wiki/Troubleshooting).

**For bugs** be sure to [search existing issues](https://github.com/adobe/brackets/issues) first.
Include steps to consistently reproduce the problem, actual vs. expected results, and your OS and
Brackets version number. Disable all extensions to verify the issue is a core Brackets bug.
[Read more guidelines for filing good bugs...](https://github.com/adobe/brackets/wiki/How-to-Report-an-Issue)

**For feature requests** please first check our [feature backlog](http://bit.ly/BracketsBacklog) to
see if it's already there; you can upvote it if so. If not, feel free to file it as an issue; we'll
move it to the feature backlog for you.

I want to help!
---------------

Awesome! Please read the [Guide to Contributing](https://github.com/adobe/brackets/blob/master/CONTRIBUTING.md)
and learn [How to Hack on Brackets](https://github.com/adobe/brackets/wiki/How-to-Hack-on-Brackets).

I want to keep track of how Brackets is doing!
----------------------------------------------

Not sure you needed the exclamation point there, but we like your enthusiasm.

**What's Brackets working on next?**

* In our [feature backlog](http://bit.ly/BracketsBacklog), the columns labeled "Sprint N"
  are features already in progress and should ship within 2 weeks. Features at the top of
  the "Product Backlog" list will come next.
* Watch our [GitHub activity stream](https://github.com/adobe/brackets/pulse).

**Contact info:**

* **Twitter:** [@brackets](http://twitter.com/#!/brackets)
* **Blog:** http://blog.brackets.io/
* **IRC:** [#brackets on freenode](http://webchat.freenode.net/?channels=brackets)
* **Developers mailing list:** http://groups.google.com/group/brackets-dev