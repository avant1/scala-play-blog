package repository.general

import models.blog.BlogPost

trait BlogPostRepository {

  val PostsPerPage = 10

  def getList(page: Int): List[BlogPost]

  def getById(id: Int): BlogPost

  def add(post: BlogPost): Unit

}
