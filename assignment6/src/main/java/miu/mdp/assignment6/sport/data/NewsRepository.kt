package miu.mdp.assignment6.sport.data

import miu.mdp.assignment6.sport.model.News
import javax.inject.Inject

class NewsRepository @Inject constructor() : Repository<News>() {
    override var data = mutableListOf(
        News(
            "Xabi Alonso showered in beer after Bayer Leverkusen's historic victory at Bundesliga",
            "Bayer Leverkusen players showered head coach Xabi Alonso in beer during a press conference after the 5-0 win against Werder Bremen that helped them win their first Bundesliga title in history.",
            "https://vcdn1-thethao.vnecdn.net/2024/04/15/GLJbnTrWAAAYSWO-1713136281.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=smKgGSqVI8iMTxb_Rw7okw"
        ),
        News(
            "Rio de Janeiro seeks sport and tourism cooperation with Vietnam",
            "Vice Mayor of Rio de Janeiro Nilton Caldeira has proposed a football exchange with Vietnam as part of celebrations marking the 35th anniversary of Vietnam-Brazil diplomatic ties.",
            "https://vcdn1-english.vnecdn.net/2024/04/15/bunghi-1713152361-1713152372-3964-1713152411.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=tF_zJX115Mw3xyoOQqh8rQ"
        ),
        News(
            "Leverkusen win first Bundesliga crown, breaking Bayern's 11-year run",
            "Bayer Leverkusen lifted the Bundesliga title for the first time in their 120-year history on Sunday, a 5-0 victory over Werder Bremen breaking Bayern Munich's 11-year stranglehold on the German top flight.",
            "https://vcdn1-english.vnecdn.net/2024/04/15/crowde-1713154060-1713154075-2737-1713154137.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=BGZJnXODugzUXTcNbMc-Gg"
        )
    )

}
