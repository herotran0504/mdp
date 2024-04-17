package miu.mdp.assignment6.sport.data

import miu.mdp.assignment6.sport.model.Profile
import javax.inject.Inject

class ProfileRepository @Inject constructor() {
    var data = Profile(
        name = "Hung Tran",
        avatar = "https://media.licdn.com/dms/image/C4E03AQEamG1WzKk_BA/profile-displayphoto-shrink_400_400/0/1517525074684?e=1718841600&v=beta&t=uBOkZ0MPb7pMqMQbRgZQANPGxieu6k9z4RtshInN_Gk",
        about = "As a table tennis player, I thrive on the rapid exchanges and precise shots that define the sport, constantly honing my skills to achieve mastery. With a passion for the game and a strategic mindset, I navigate the table with agility and finesse, always seeking new challenges and opportunities for growth."
    )
}