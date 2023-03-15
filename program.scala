package karazin.scala.users.group.week1.homework

// Do not forget to import custom implementation
import adt._

import model._
import services._


object program:
  /*
   Getting view for all user's posts
   Provide a result type
  */

  def getPostsViews(): List[PostView] = {
    val allPosts: List[Post] = PostService.getAllPosts()
    allPosts.map(post => PostViewService.getPostView(post))
  }
  /*
    Getting view for a particular user's post
    Provide an argument and a result type
  */

  def getPostView(post: Post): PostView = PostViewService.getPostView(post)
  /*
   Provide desugared version of the previous two methods
  */

  def getPostsViewDesugared(): List[PostView] = {
    val allPosts: List[Post] = PostService.getAllPosts()
    val postViews: List[PostView] = allPosts.map((post: Post) => PostViewService.getPostView(post))
    postViews
  }
  