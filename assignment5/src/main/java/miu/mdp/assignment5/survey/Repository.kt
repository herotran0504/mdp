package miu.mdp.assignment5.survey

class Repository {

    fun getFoodQuestions() = listOf(
        Question(
            id = 2,
            text = "Are you a vegetarian?",
            options = listOf(
                Option(id = 21, text = "Yes"),
                Option(id = 22, text = "No")
            )
        ),
        Question(
            id = 3,
            text = "Do you like spicy food?",
            options = listOf(
                Option(id = 31, text = "Yes"),
                Option(id = 32, text = "No")
            )
        ),
        Question(
            id = 4,
            text = "How often do you eat out in a week?",
            options = listOf(
                Option(id = 41, text = "Never"),
                Option(id = 42, text = "1-2 times"),
                Option(id = 43, text = "3-4 times"),
                Option(id = 44, text = "More than 4 times")
            )
        ),
        Question(
            id = 6,
            text = "Do you have any food allergies?",
            options = listOf(
                Option(id = 61, text = "Yes"),
                Option(id = 62, text = "No")
            )
        ),
        Question(
            id = 7,
            text = "How adventurous are you with trying new cuisines?",
            options = listOf(
                Option(id = 71, text = "Very adventurous"),
                Option(id = 72, text = "Somewhat adventurous"),
                Option(id = 73, text = "Not adventurous at all")
            )
        ),
        Question(
            id = 8,
            text = "Do you prefer coffee or tea?",
            options = listOf(
                Option(id = 81, text = "Coffee"),
                Option(id = 82, text = "Tea")
            )
        ),
        Question(
            id = 9,
            text = "How often do you eat fruits in a day?",
            options = listOf(
                Option(id = 91, text = "Never"),
                Option(id = 92, text = "1-2 times"),
                Option(id = 93, text = "3-4 times"),
                Option(id = 94, text = "More than 4 times")
            )
        ),
        Question(
            id = 11,
            text = "How do you like your eggs?",
            options = listOf(
                Option(id = 111, text = "Scrambled"),
                Option(id = 112, text = "Fried"),
                Option(id = 113, text = "Boiled"),
                Option(id = 114, text = "Poached")
            )
        ),
        Question(
            id = 12,
            text = "Do you enjoy spicy street food?",
            options = listOf(
                Option(id = 121, text = "Yes"),
                Option(id = 122, text = "No")
            )
        ),
        Question(
            id = 13,
            text = "How do you like your steak cooked?",
            options = listOf(
                Option(id = 131, text = "Rare"),
                Option(id = 132, text = "Medium Rare"),
                Option(id = 133, text = "Medium"),
                Option(id = 134, text = "Well Done")
            )
        ),
        Question(
            id = 14,
            text = "Do you enjoy trying new dessert recipes?",
            options = listOf(
                Option(id = 141, text = "Yes"),
                Option(id = 142, text = "No")
            )
        ),
        Question(
            id = 15,
            text = "How often do you drink water in a day?",
            options = listOf(
                Option(id = 151, text = "Rarely"),
                Option(id = 152, text = "1-2 glasses"),
                Option(id = 153, text = "3-4 glasses"),
                Option(id = 154, text = "More than 4 glasses")
            )
        ),
        Question(
            id = 16,
            text = "Do you enjoy trying exotic fruits?",
            options = listOf(
                Option(id = 161, text = "Yes"),
                Option(id = 162, text = "No")
            )
        ),
        Question(
            id = 19,
            text = "How often do you eat out at fine-dining restaurants?",
            options = listOf(
                Option(id = 191, text = "Rarely"),
                Option(id = 192, text = "Occasionally"),
                Option(id = 193, text = "Frequently"),
                Option(id = 194, text = "Very often")
            )
        ),
        Question(
            id = 20,
            text = "Do you enjoy pairing wine with your meals?",
            options = listOf(
                Option(id = 201, text = "Yes"),
                Option(id = 202, text = "No")
            )
        )
    )

    fun getDietaryQuestions() = listOf(
        Question(
            id = 21,
            text = "Do you follow a specific dietary plan (e.g., Mediterranean, Atkins)?",
            options = listOf(
                Option(id = 211, text = "Yes"),
                Option(id = 212, text = "No")
            )
        ),
        Question(
            id = 22,
            text = "How often do you include vegetables in your meals?",
            options = listOf(
                Option(id = 221, text = "Rarely"),
                Option(id = 222, text = "1-2 times a week"),
                Option(id = 223, text = "3-4 times a week"),
                Option(id = 224, text = "Almost every day")
            )
        ),
        Question(
            id = 23,
            text = "Do you have any specific dietary restrictions (e.g., gluten-free, lactose-free)?",
            options = listOf(
                Option(id = 231, text = "Yes"),
                Option(id = 232, text = "No")
            )
        ),
        Question(
            id = 24,
            text = "How often do you consume processed foods?",
            options = listOf(
                Option(id = 241, text = "Rarely"),
                Option(id = 242, text = "Occasionally"),
                Option(id = 243, text = "Frequently"),
                Option(id = 244, text = "Almost daily")
            )
        ),
        Question(
            id = 25,
            text = "Do you practice intermittent fasting?",
            options = listOf(
                Option(id = 251, text = "Yes"),
                Option(id = 252, text = "No")
            )
        ),
        Question(
            id = 26,
            text = "How often do you eat meals prepared at home?",
            options = listOf(
                Option(id = 261, text = "Rarely"),
                Option(id = 262, text = "1-2 times a week"),
                Option(id = 263, text = "3-4 times a week"),
                Option(id = 264, text = "Almost every day")
            )
        ),
        Question(
            id = 27,
            text = "Do you take dietary supplements regularly?",
            options = listOf(
                Option(id = 271, text = "Yes"),
                Option(id = 272, text = "No")
            )
        ),
        Question(
            id = 28,
            text = "How often do you consume sugary beverages?",
            options = listOf(
                Option(id = 281, text = "Rarely"),
                Option(id = 282, text = "Occasionally"),
                Option(id = 283, text = "Frequently"),
                Option(id = 284, text = "Almost daily")
            )
        ),
        Question(
            id = 29,
            text = "Do you have a specific meal timing routine (e.g., fixed meal times)?",
            options = listOf(
                Option(id = 291, text = "Yes"),
                Option(id = 292, text = "No")
            )
        ),
        Question(
            id = 30,
            text = "How often do you consume dairy products?",
            options = listOf(
                Option(id = 301, text = "Rarely"),
                Option(id = 302, text = "1-2 times a week"),
                Option(id = 303, text = "3-4 times a week"),
                Option(id = 304, text = "Almost every day")
            )
        ),
        Question(
            id = 31,
            text = "Do you follow a vegetarian or vegan diet?",
            options = listOf(
                Option(id = 311, text = "Vegetarian"),
                Option(id = 312, text = "Vegan"),
                Option(id = 313, text = "Neither")
            )
        ),
        Question(
            id = 32,
            text = "How often do you include nuts and seeds in your diet?",
            options = listOf(
                Option(id = 321, text = "Rarely"),
                Option(id = 322, text = "1-2 times a week"),
                Option(id = 323, text = "3-4 times a week"),
                Option(id = 324, text = "Almost every day")
            )
        ),
        Question(
            id = 33,
            text = "Do you track your daily calorie intake?",
            options = listOf(
                Option(id = 331, text = "Yes"),
                Option(id = 332, text = "No")
            )
        ),
        Question(
            id = 34,
            text = "How often do you include whole grains in your meals?",
            options = listOf(
                Option(id = 341, text = "Rarely"),
                Option(id = 342, text = "1-2 times a week"),
                Option(id = 343, text = "3-4 times a week"),
                Option(id = 344, text = "Almost every day")
            )
        ),
        Question(
            id = 35,
            text = "Do you follow a low-carb or ketogenic diet?",
            options = listOf(
                Option(id = 351, text = "Yes"),
                Option(id = 352, text = "No")
            )
        ),
        Question(
            id = 36,
            text = "How often do you consume red meat?",
            options = listOf(
                Option(id = 361, text = "Rarely"),
                Option(id = 362, text = "1-2 times a week"),
                Option(id = 363, text = "3-4 times a week"),
                Option(id = 364, text = "Almost every day")
            )
        ),
        Question(
            id = 37,
            text = "Do you practice mindful eating?",
            options = listOf(
                Option(id = 371, text = "Yes"),
                Option(id = 372, text = "No")
            )
        ),
        Question(
            id = 38,
            text = "How often do you consume fermented foods (e.g., yogurt, sauerkraut)?",
            options = listOf(
                Option(id = 381, text = "Rarely"),
                Option(id = 382, text = "1-2 times a week"),
                Option(id = 383, text = "3-4 times a week"),
                Option(id = 384, text = "Almost every day")
            )
        ),
        Question(
            id = 39,
            text = "Do you have specific dietary goals (e.g., weight loss, muscle gain)?",
            options = listOf(
                Option(id = 391, text = "Yes"),
                Option(id = 392, text = "No")
            )
        ),
        Question(
            id = 40,
            text = "How often do you consume fast food or takeout?",
            options = listOf(
                Option(id = 401, text = "Rarely"),
                Option(id = 402, text = "Occasionally"),
                Option(id = 403, text = "Frequently"),
                Option(id = 404, text = "Almost daily")
            )
        )
    )

}