package miu.mdp.assignment6.sport.data

import miu.mdp.assignment6.sport.model.Athlete

class AthletesRepository : Repository<Athlete>() {

    override var data = mutableListOf(
        Athlete(
            name = "Michael Phelps",
            sport = "Swimming",
            country = "United States",
            bestPerformance = "Winning 8 gold medals in the 2008 Beijing Olympics",
            medals = 28,
            facts = "Phelps is the most decorated Olympian of all time."
        ),
        Athlete(
            name = "Usain Bolt",
            sport = "Athletics",
            country = "Jamaica",
            bestPerformance = "Setting the world records in the 100m and 200m sprint events",
            medals = 8,
            facts = "Bolt is widely considered the greatest sprinter of all time."
        ),
        Athlete(
            name = "Serena Williams",
            sport = "Tennis",
            country = "United States",
            bestPerformance = "Winning 23 Grand Slam singles titles",
            medals = 4,
            facts = "Williams is one of the greatest tennis players of all time, male or female."
        ),
        Athlete(
            name = "Simone Biles",
            sport = "Gymnastics",
            country = "United States",
            bestPerformance = "Winning multiple gold medals in the Olympic Games",
            medals = 32,
            facts = "Biles is considered one of the greatest gymnasts of all time."
        ),
        Athlete(
            name = "Lionel Messi",
            sport = "Soccer",
            country = "Argentina",
            bestPerformance = "Winning multiple FIFA Ballon d'Or awards",
            medals = 34,
            facts = "Messi is regarded as one of the greatest football players of all time."
        ),
        Athlete(
            name = "Roger Federer",
            sport = "Tennis",
            country = "Switzerland",
            bestPerformance = "Holding the record for the most Grand Slam titles in men's singles",
            medals = 20,
            facts = "Federer is considered one of the greatest tennis players of all time."
        ),
        Athlete(
            name = "Michael Jordan",
            sport = "Basketball",
            country = "United States",
            bestPerformance = "Winning six NBA championships with the Chicago Bulls",
            medals = 6,
            facts = "Jordan is widely regarded as the greatest basketball player of all time."
        ),
        Athlete(
            name = "Cristiano Ronaldo",
            sport = "Soccer",
            country = "Portugal",
            bestPerformance = "Winning multiple FIFA Ballon d'Or awards",
            medals = 32,
            facts = "Ronaldo is one of the most prolific goal scorers in football history."
        )
    )

}