# text-rendering

a tool that render plaintext into richtext file allow user customize themes/style.

## The problem it solves

Plaintext is so simple and easy to edit and compare. Particularly, It's better than binary files to be included in VCS.

Despite richtext's the capability of representation is amazing, it's complicated to maintain a document with big size. Because the styles are tightly coupled with the content.

An obvious demand in content creation is to write with plaintext and present with richtext, but it has remained unresolved for a long period of time.

I found that [`markdown`](https://datatracker.ietf.org/doc/html/rfc7763) fulfill all my desire. I have been getting benefit from markdown:

- Light-weight markup syntax let itself more readable than html
- The essence is still plaintext make itself easy to track with VCS
- Supported by a large number of platforms, so migration in different systems shouldn't be hard.
- Easy to customize theme. Actually, you can rendering it with any style you like

However, when I see a real-time co-authoring system like google docs, I realize that the story is far from complete.

User habits are difficult to cultivate as well as trust. I would rather render plaintext into richtext format document such as [WordProcessingML](http://officeopenxml.com/anatomyofOOXML.php), PDF, etc.

WordProcessingML support:

- [Pandoc](https://pandoc.org/) - a universal document converter

Markdown support:

* javascript:
  - [markdown-it](https://github.com/markdown-it/markdown-it)
  - [marked](https://github.com/markedjs/marked)
