package karazin.scala.users.group.week1.homework

import java.util.UUID

// Do not forget to import custom implementation
import adt._
import model._

/*
  Dummy services
  
  The services need to be implemented in case of running the code
 */
object services:
  def getUserProfile(): ErrorOr[UserProfile] =
    ErrorOr(UserProfile(UUID.randomUUID(), "John", "Doe"))

  def getPosts(userId: UUID): ErrorOr[List[Post]] =
    ErrorOr(List(Post(UUID.randomUUID(), userId, "Title", "Content")))

  def getComments(postId: UUID): ErrorOr[List[Comment]] =
    ErrorOr(List(Comment(UUID.randomUUID(), postId, UUID.randomUUID(), "Comment")))

  def getLikes(postId: UUID): ErrorOr[List[Like]] =
    ErrorOr(List(Like(UUID.randomUUID(), postId, UUID.randomUUID())))

  def getShares(postId: UUID): ErrorOr[List[Share]] =
    ErrorOr(List(Share(UUID.randomUUID(), postId, UUID.randomUUID())))