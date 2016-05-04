package templating

object helpers {
  import views.html.helper.FieldConstructor

  implicit val myFields = FieldConstructor(views.html.form.semanticui.fieldconstructor.apply)
}
