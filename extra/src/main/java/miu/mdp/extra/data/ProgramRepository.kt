package miu.mdp.extra.data

import kotlinx.coroutines.delay
import miu.mdp.extra.model.Program
import javax.inject.Inject

interface MessageRepository {
    suspend fun getMessages(): List<Program>
}

internal class MessageRepositoryImpl @Inject constructor() : MessageRepository {

    override suspend fun getMessages(): List<Program> {
        delay(100)
        return PROGRAMS
    }
}

internal val PROGRAMS = listOf(
    Program(
        "APPLIED ARTS & SCIENCES",
        "THE FAST-TRACK DEGREE FOR TRANSFER STUDENTS\n" +
                "Graduate in as little as two semesters\n" +
                "Gain the practical skills valued most by employers\n" +
                "Join a supportive community of students and faculty\n" +
                "Discover how \u200Beverything you study \u200Bconnects\u200B to your inner self\n" +
                "First-year students are also welcome to join this program\n" +
                "Federal grants and loans typically cover all or most costs for US students",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/liberal-bg.jpg"
    ),
    Program(
        "CINEMATIC ARTS, NEW MEDIA & SCREENWRITING",
        "MEDITATE AND CREATE\n" +
                "Create something extraordinary that speaks to people on a deep level\n" +
                "Realize your creative vision through design, visual aesthetics, sound, and more\n" +
                "Master techniques related to camera, software, storytelling, troubleshooting, and the creative process\n" +
                "Create a professional portfolio to help launch your career in media\n" +
                "Federal grants and loans typically cover all or most costs for US students",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/mc-bg.jpg"
    ),
    Program(
        "COMPUTER SCIENCE",
        "PREPARE FOR A CAREER IN A FAST-GROWING FIELD\n" +
                "Learn computer programming, data algorithms, web development, and more\n" +
                "Focus on one full-time course per month to learn more with less stress\n" +
                "Enhance your creativity through practice of the Transcendental Meditation® technique\n" +
                "Learn from expert professors who support your personal growth and academic success\n" +
                "Federal grants and loans typically cover all or most costs for US students",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/computerscience-bg.jpg"
    ),
    Program(
        "ART, CONSCIOUSNESS,\nCREATIVE PRACTICE",
        "CREATING FROM WITHIN\n" +
                "Learn to “make the invisible visible,” and deliver a point of view\n" +
                "Thrive in an interdisciplinary studio with a focus on self-development\n" +
                "Dive deep and maximize focus with one course at a time\n" +
                "Connect with professionals through an extensive visiting artist program\n" +
                "Develop creativity and resilience through mentorship from faculty\n" +
                "Federal grants and loans typically cover all or most costs for US students",
        "https://www.miu.edu/wp-content/uploads/sites/2/2023/05/art3-bg.jpg"
    ),
    Program(
        "AYURVEDA & INTEGRATIVE HEALTH",
        "BECOME AN AYURVEDA\n" +
                "PROFESSIONAL\n" +
                "Integrate Ayurvedic knowledge with modern health science\n" +
                "Join the only accredited bachelor’s in Ayurveda in the US\n" +
                "Engage with a supportive community of like-minded students\n" +
                "Available online or on-campus\n" +
                "Federal grants and loans typically cover all or most costs for US students\n",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/physiology-bg.jpg"
    ),
    Program(
        "BUSINESS",
        "CREATIVE INNOVATION TO TRANSFORM SOCIETY\n" +
                "Gain the skills and knowledge to start, or work in, a sustainable, socially responsible business\n" +
                "Learn experimentally through creative and interactive workshops\n" +
                "Enjoy feedback from world-class mentors, with small class size for one-on-one guidance\n" +
                "Learn more with less stress through immersion in one course per month\n" +
                "Federal grants and loans typically cover all or most costs for US students",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/business2-bg.jpg"
    ),
    Program(
        "CONSCIOUSNESS & HUMAN POTENTIAL",
        "ENLIVEN YOUR INNER POTENTIAL\n" +
                "Examine modern perspectives on consciousness in light of Maharishi Vedic Science\n" +
                "Study the philosophy of Yoga and how it enhances your life\n" +
                "Learn strategies for social transformation and how they can lead to a more peaceful world\n" +
                "Federal grants and loans typically cover all or most costs for US students",
        "https://www.miu.edu/wp-content/uploads/sites/2/2020/02/lit-bg3.jpg"
    ),
    Program(
        "MATHEMATICS",
        "Explore the language of life\n" +
                "From the architecture of a skyscraper to the spiral of a seashell, everything around us follows mathematical laws.",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/math-bg.jpg"
    ),
    Program(
        "PHYSICS",
        "TOWARD A PHYSICS OF CONSCIOUSNESS\n" +
                "Advance your knowledge of cutting-edge theoretical and experimental physics\n" +
                "Unify consciousness and material existence in a profound, meaningful way\n" +
                "Study with leading researchers as your professors\n" +
                "Become an expert in quantum mechanics, quantum field theory, quantum computing, general relativity, and string theory",
        "https://www.miu.edu/wp-content/uploads/sites/2/2023/09/physics-bg.jpg"
    ),
    Program(
        "REGENERATIVE ORGANIC AGRICULTURE",
        "Sustainable Is Not Enough\n" + "" +
                "Gain extensive hands-on experience in running a regenerative, organic farm from seed to sale\n" +
                "Learn how to regenerate soils, maximize water efficiency, and increase biodiversity throughout your landscape\n" +
                "Receive personalized mentorship from experts in the field of regenerative agriculture",
        "https://www.miu.edu/wp-content/uploads/sites/2/2021/03/roa-bg.jpg"
    ),
    Program(
        "SUSTAINABLE & REGENERATIVE LIVING",
        "Design, build, and live in a way that replenishes the health of people, communities, and our planet.\n" +
                "Learn by doing, with meaningful community-centered projects\n" +
                "Learn how to design and build your own eco-home and produce your own renewable energy\n" +
                "Focus deeply and learn without stress, taking one immersive course at a time\n" +
                "Step into the future with Narrative Evaluations\n" +
                "Prioritize your health and wellness with local organic food\n" +
                "Discover and develop your inner self in daily group meditations\n" +
                "Integrate your studies with your dream career via meaningful internships and senior projects",
        "https://www.miu.edu/wp-content/uploads/sites/2/2018/03/sl-bg.jpg"
    )
)
