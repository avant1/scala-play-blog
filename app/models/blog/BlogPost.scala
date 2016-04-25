package models.blog

class BlogPost(dto: BlogPostDto) {

  private val PreviewLength = 18

  val title = dto.title
  val content = dto.content
  val author = "me"

  private val id = BlogPost.generateNextId()

  def preview = {
    content.substring(0, PreviewLength) + "..."
  }

  def getId = id

}

object BlogPost {

  var lastId = 0

  def generateNextId() = {
    lastId = lastId + 1
    lastId
  }

}
