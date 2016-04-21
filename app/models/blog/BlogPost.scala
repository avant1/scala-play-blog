package models.blog

class BlogPost(dto: BlogPostDto) {

  val title = dto.title
  val content = dto.content
  val author = "me"


}
