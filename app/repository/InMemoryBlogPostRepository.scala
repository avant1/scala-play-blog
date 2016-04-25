package repository

import models.blog.BlogPost
import repository.general.BlogPostRepository

import scala.collection.mutable.ListBuffer

object InMemoryBlogPostRepository extends BlogPostRepository {

  val posts = ListBuffer[BlogPost]()

  override def getList(page: Int): List[BlogPost] = {
    val from = (page - 1) * PostsPerPage
    posts.slice(from, from + PostsPerPage).toList
  }

  override def getById(id: Int): BlogPost = {
    throw new NotImplementedError()
  }

  override def add(post: BlogPost): Unit = {
    posts += post
  }
}
