package controllers

import javax.inject._

import models.blog.{BlogPost, BlogPostDto}
import org.joda.time._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, MessagesApi}
import repository.InMemoryBlogPostRepository


@Singleton
class BlogController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  val blogPostRepository = InMemoryBlogPostRepository

  val blogPostForm = Form(
    mapping(
      "title" -> nonEmptyText,
      "content" -> nonEmptyText(minLength = 101),
      "isHidden" -> boolean
    )(BlogPostDto.apply)(BlogPostDto.unapply)
  )


  def index() = Action {
    Ok(views.html.blog.index(blogPostRepository.getList()))
  }


  def addPost() = Action { request =>
    Ok(views.html.blog.addPost(blogPostForm))
  }

  def savePost() = Action { implicit request =>
    blogPostForm.bindFromRequest().fold(
      formWithErrors => {
        BadRequest(views.html.blog.addPost(formWithErrors))
      },

      blogPostDto => {
        val blogPost = new BlogPost(blogPostDto)
        blogPostRepository.add(blogPost)

        Redirect(routes.BlogController.index())
      }
    )
  }

  def view(id: Int) = Action { request =>

    val post = blogPostRepository.getById(id)


    Ok(views.html.blog.view(post))
  }

}
