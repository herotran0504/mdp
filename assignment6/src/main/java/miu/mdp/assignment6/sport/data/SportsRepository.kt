package miu.mdp.assignment6.sport.data

import miu.mdp.assignment6.sport.model.Sport
import miu.mdp.assignment6.sport.model.SportType

class SportsRepository : Repository<Sport>() {
    override var data = mutableListOf(
        Sport(
            SportType.Measure,
            "Running",
            "Running is a sport that measures your speed and endurance over various distances. It's a fantastic cardiovascular exercise that can be done solo or in groups, on roads, tracks, or trails. Whether you're aiming for personal records or just enjoying the rhythm of your stride, running offers a fulfilling way to stay fit and active."
        ),
        Sport(
            SportType.Precision,
            "Archery",
            "Archery is a precision sport where participants use a bow to shoot arrows at a target. It requires focus, patience, and control to consistently hit the bullseye. Archery has a rich history dating back to ancient times and is enjoyed both recreationally and competitively."
        ),
        Sport(
            SportType.Spectacle,
            "Gymnastics",
            "Gymnastics is a breathtaking sport that showcases flexibility, strength, and grace. Athletes perform routines on various apparatus such as the balance beam, uneven bars, and floor exercise, combining acrobatic skills with artistic expression. Whether you're flipping through the air or balancing on a narrow beam, gymnastics captivates audiences with its beauty and athleticism."
        ),
        Sport(
            SportType.Combat,
            "Boxing",
            "Boxing is a combat sport that involves two opponents engaging in a regulated match of punches and defensive maneuvers. It requires skill, strategy, and conditioning to outmaneuver and outscore your opponent while minimizing damage. Boxing has a rich tradition and is admired for its combination of athleticism, courage, and sportsmanship."
        ),
        Sport(
            SportType.Play,
            "Soccer",
            "Soccer, also known as football in many countries, is the world's most popular sport, played by millions of people of all ages. It's a team sport that involves kicking a ball to score goals while defending your own goal. Soccer combines athleticism, strategy, and teamwork, making it a thrilling and dynamic game enjoyed by fans worldwide."
        ),
        Sport(
            SportType.Measure,
            "Swimming",
            "Swimming is a versatile sport that offers a full-body workout and improves cardiovascular health. Whether you're swimming laps in a pool, crossing open water, or competing in races, swimming challenges your endurance and technique. With strokes like freestyle, breaststroke, backstroke, and butterfly, swimming provides a low-impact way to stay active and fit."
        ),
        Sport(
            SportType.Precision,
            "Shooting",
            "Shooting sports involve using firearms or airguns to hit a target accurately from a distance. It requires focus, control, and precision to consistently achieve high scores. Shooting encompasses various disciplines such as rifle, pistol, shotgun, and precision air rifle, each with its own set of challenges and techniques."
        ),
        Sport(
            SportType.Spectacle,
            "Figure Skating",
            "Figure skating is a mesmerizing sport that combines athleticism and artistry on ice. Athletes perform intricate routines filled with jumps, spins, and footwork, set to music. Figure skating competitions showcase elegance, creativity, and technical skill, captivating audiences with breathtaking performances."
        ),
        Sport(
            SportType.Combat,
            "Judo",
            "Judo is a martial art and combat sport that focuses on throwing and grappling techniques to overcome opponents. It emphasizes leverage, balance, and timing rather than brute strength, making it suitable for practitioners of all ages and sizes. Judo promotes discipline, respect, and self-confidence while providing a challenging yet rewarding physical workout."
        )
    )

}