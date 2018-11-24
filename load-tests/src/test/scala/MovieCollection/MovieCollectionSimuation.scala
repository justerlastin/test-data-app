package MovieCollection

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._


class MovieCollectionSimuation extends Simulation {

  val baseUrl = "http://test-data-app.apps.hn-vm-openshift1.lastr.co/";

  val httpProtocol = http.baseUrl(baseUrl);

  val movieCollectionScenario = scenario("Movie Collection")
    .exec(http("getMovieCollection")
      .get("/movieCollection")
    ).pause(5 seconds)


  setUp(movieCollectionScenario.inject(constantUsersPerSec(1) during(1 second))).protocols(httpProtocol)
}
