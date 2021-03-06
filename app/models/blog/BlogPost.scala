package models.blog

class BlogPost(dto: BlogPostDto) {

  private val PreviewLength = 18

  val title = dto.title
  val content = dto.content
  val author = "me"
  val isHidden = dto.isHidden

  private val id = BlogPost.generateNextId()

  def preview = {
    content.substring(0, PreviewLength) + "..."
  }

  def getId = id

  def renderedContent = content.replace("\n", "<br/>")

}

object BlogPost {

  var lastId = 0

  def generateNextId() = {
    lastId = lastId + 1
    lastId
  }

}
