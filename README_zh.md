# text-rendering

纯文本非常简单，易于编写、文本比较、版本控制。
富文本相对而言，表现能力更强，但是结构复杂，在甄误和版本控制方面处于劣势。文档的排版和格式成为了内容的一部分，常常使用户感到心力交瘁。

一个显而易见，却长期得不到解决的需求是：以纯文本的方式创作，以富文本的方式呈现。

`markdown`在website领域满足了这样的需求。

使用`markdown`编辑和管理文档有不少优点：

- 轻量的文本标记格式，可读性极强
- 本质仍然是纯文本，可进行文本比较，可版本控制
- 广泛的支持，不同平台，应用，工具之间的迁移成本较低
- 主题风格的可定制性极强

然而，当我看到google doc的多人协同编辑带来的强大协作交互能力，我知道故事并没有结束。

用户习惯难以改变，用户信任也难以获得。与其提议其他人使用新的工具，不如将纯文本渲染到[OOXML](http://officeopenxml.com/)，确切的说，是[WordProcessingML](http://officeopenxml.com/anatomyofOOXML.php)。

WordProcessingML support:

- [Pandoc](https://pandoc.org/) - a universal document converter

Markdown support:

* javascript:
  - [markdown-it](https://github.com/markdown-it/markdown-it)
  - [marked](https://github.com/markedjs/marked)


