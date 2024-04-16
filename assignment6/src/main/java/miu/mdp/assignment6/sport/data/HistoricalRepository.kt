package miu.mdp.assignment6.sport.data

import miu.mdp.assignment6.sport.model.Historical
import miu.mdp.core.parseToDate

class HistoricalRepository : Repository<Historical>() {

    override var data = mutableListOf(
        Historical(
            name = "First Modern Olympic Games",
            description = "The first modern Olympic Games, held in Athens, Greece.",
            date = "06/03/1896".parseToDate()
        ),
        Historical(
            name = "Jesse Owens at the 1936 Olympics",
            description = "Jesse Owens won four gold medals in track and field events at the 1936 Summer Olympics in Berlin, Germany.",
            date = "01/08/1936".parseToDate()
        ),
        Historical(
            name = "Miracle on Ice",
            description = "The United States men's ice hockey team defeated the Soviet Union at the 1980 Winter Olympics in Lake Placid, New York.",
            date = "20/02/1980".parseToDate()
        ),
        Historical(
            name = "Muhammad Ali vs. Sonny Liston II",
            description = "Muhammad Ali won the World Heavyweight Championship for the first time by defeating Sonny Liston in their second match in Lewiston, Maine.",
            date = "25/05/1965".parseToDate()
        ),
        Historical(
            name = "Jackie Robinson's MLB Debut",
            description = "Jackie Robinson became the first African American to play in Major League Baseball when he debuted for the Brooklyn Dodgers.",
            date = "15/04/1947".parseToDate()
        ),
        Historical(
            name = "Roger Bannister's Four-Minute Mile",
            description = "Roger Bannister became the first person to run a mile in under four minutes.",
            date = "06/05/1954".parseToDate()
        ),
        Historical(
            name = "Opening of the All England Lawn Tennis and Croquet Club",
            description = "The All England Lawn Tennis and Croquet Club, host of the Wimbledon Championships, opened in London, England.",
            date = "23/07/1868".parseToDate()
        )
    )

}