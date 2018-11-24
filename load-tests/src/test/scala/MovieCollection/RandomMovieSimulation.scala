package MovieCollection

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._


class RandomMovieSimulation extends Simulation {

  val baseUrl = "http://test-data-app.apps.hn-vm-openshift1.lastr.co/";

  val httpProtocol = http.baseUrl(baseUrl);

  val randomMovieScenario = scenario("Create Random Movies")
    .exec(http("post")
      .post("/movie")
    )


  setUp(randomMovieScenario.inject(constantUsersPerSec(100) during(60 second))).protocols(httpProtocol)
}
