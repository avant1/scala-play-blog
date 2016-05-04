package repository

import models.blog.{BlogPost, BlogPostDto}
import repository.general.BlogPostRepository

import scala.collection.mutable.ListBuffer

object InMemoryBlogPostRepository extends BlogPostRepository {
  def reset() = posts.remove(0, posts.length)

  val posts = ListBuffer[BlogPost](
    //    new BlogPost(BlogPostDto("Awesome title!",
    //      """
    //        |Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum feugiat felis vel lacus ullamcorper, vel viverra libero consectetur. Nam eu fermentum odio. In hac habitasse platea dictumst. Nunc malesuada massa eu eleifend elementum. Fusce sagittis justo quam, ut posuere nisl faucibus ac. Maecenas eget nunc hendrerit, molestie sem sed, tincidunt lectus. Proin egestas risus in facilisis placerat. Mauris porta neque nec aliquam semper. Quisque quis volutpat sapien. Suspendisse consectetur, purus et dignissim egestas, leo neque rhoncus neque, vitae vehicula diam diam non lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer scelerisque vehicula enim id pharetra. Donec pellentesque quis leo eu maximus. Duis posuere sagittis ultrices. Maecenas mollis ligula commodo faucibus interdum. In malesuada erat malesuada congue tempus.
    //        |
    //        |Maecenas malesuada rhoncus consequat. Ut eget nisl eget ipsum porta tincidunt a a nisl. Cras nec semper enim. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent eleifend felis ut felis pharetra hendrerit. Aliquam nec scelerisque massa. Donec quis pharetra nunc, at scelerisque lacus. Praesent non convallis tellus, sit amet blandit urna. Pellentesque non lobortis metus, placerat pharetra nulla. Maecenas ut leo suscipit, pellentesque lorem id, iaculis justo. Sed auctor justo vel tortor interdum porta.
    //      """.stripMargin, isHidden = false))
  )

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
