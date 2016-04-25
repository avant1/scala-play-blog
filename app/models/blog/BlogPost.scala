package models.blog

class BlogPost(dto: BlogPostDto) {

  private val PreviewLength = 18

  val title = dto.title
  val content = dto.content
  val author = "me"

  def preview = {
    content.substring(0, PreviewLength) + "..."
  }


}
