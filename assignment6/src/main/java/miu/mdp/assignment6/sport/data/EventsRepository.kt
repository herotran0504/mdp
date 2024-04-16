package miu.mdp.assignment6.sport.data

import miu.mdp.assignment6.sport.model.Event
import miu.mdp.core.parseToDate

class EventsRepository : Repository<Event>() {
    override var data = mutableListOf(
        Event(
            name = "2024 Summer Olympics",
            description = "The 2024 Summer Olympics, officially known as the Games of the XXXIII Olympiad, will be held in Paris, France.",
            date = "26/07/2024".parseToDate()
        ),
        Event(
            name = "2024 UEFA European Championship",
            description = "The 2024 UEFA European Football Championship, commonly referred to as UEFA Euro 2024, will be the 17th edition of the UEFA European Championship.",
            date = "12/06/2024".parseToDate()
        ),
        Event(
            name = "2024 FIFA World Cup",
            description = "The 2024 FIFA World Cup will be the 23rd FIFA World Cup, the quadrennial international men's football championship contested by the national teams of the member associations of FIFA.",
            date = "11/05/2024".parseToDate()
        ),
        Event(
            name = "2024 Wimbledon Championships",
            description = "The 2024 Wimbledon Championships will be the 138th edition of the tournament and will take place at the All England Lawn Tennis and Croquet Club in London, England.",
            date = "24/06/2024".parseToDate()
        ),
        Event(
            name = "2024 Tour de France",
            description = "The 2024 Tour de France will be the 108th edition of the Tour de France, one of cycling's three grand tours.",
            date = "29/06/2024".parseToDate()
        ),
        Event(
            name = "2024 Winter Olympics",
            description = "The 2024 Winter Olympics, officially known as the XXVI Olympic Winter Games, will be held in Milan-Cortina, Italy.",
            date = "29/07/2024".parseToDate()
        ),
        Event(
            name = "2024 Rugby World Cup",
            description = "The 2024 Rugby World Cup will be the tenth Rugby World Cup, the quadrennial rugby union world championship.",
            date = "06/09/2024".parseToDate()
        )
    )

}
