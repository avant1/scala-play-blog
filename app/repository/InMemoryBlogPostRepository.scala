package repository

import models.blog.BlogPost
import repository.general.BlogPostRepository

import scala.collection.mutable.ListBuffer

object InMemoryBlogPostRepository extends BlogPostRepository {

  val posts = ListBuffer[BlogPost]()

  override def getList(page: Int = 1): List[BlogPost] = {
    val from = (page - 1) * PostsPerPage
    posts.filter(post => !post.isHidden).slice(from, from + PostsPerPage).toList.reverse
  }

  override def getById(id: Int): BlogPost = {
    posts.filter(post => post.getId == id).head
  }

  override def add(post: BlogPost): Unit = {
    posts += post
  }
}
