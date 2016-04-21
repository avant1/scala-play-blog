package controllers

import javax.inject._

import models.blog.{BlogPost, BlogPostDto}
import org.joda.time._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, MessagesApi}


@Singleton
class BlogController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  var blogPosts: Array[BlogPost] = Array(
    new BlogPost(BlogPostDto("das is first post", "rly")),
    new BlogPost(BlogPostDto("keep up working on my blog", "can you beleive this?"))
  )

  val blogPostForm = Form(
    mapping(
      "title" -> nonEmptyText,
      "content" -> nonEmptyText(minLength = 101)
    )(BlogPostDto.apply)(BlogPostDto.unapply)
  )


  def index() = Action {
    Ok(views.html.blog.index(blogPosts.reverse))
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


        blogPosts = blogPosts :+ blogPost

        Redirect(routes.BlogController.index())


      }
    )
  }



}