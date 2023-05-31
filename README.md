DISCORD BOT
    
Features:
    
Sends a welcome message to users when the "welcome" slash command is invoked.

Retrieves and displays all roles in the server when the "roles" slash command is triggered.

Allows users to send custom messages through the bot using the "say" slash command, with the option to specify the target channel.

Responds with predefined messages based on the emote specified in the "emote" slash command.

Enables role assignment to users using the "giverole" slash command.

Sends a message whenever a user reacts to a message with an emoji.
    
Sends a "Bot is ready!" message when the bot is fully connected and ready to operate.

Echoes any non-empty, non-bot messages received in the designated channel.

Provides information about users' online status updates, indicating the number of members online in the server.

Manages slash commands for guilds, allowing for easy creation and updating of command functionalities.   


Requirements: 


Java Development Kit (JDK): Make sure you have Java 8 or a higher version installed on your system.

Gradle: Ensure that Gradle is installed on your machine. You can download it from the official Gradle website (https://gradle.org/install/).

IntelliJ IDEA: Install IntelliJ IDEA, a popular Java IDE. You can download the Community Edition (free) or the Ultimate Edition (paid) from the JetBrains website (https://www.jetbrains.com/idea/download/).

JDA Library: Add the JDA (Java Discord API) library as a dependency in your Gradle build file (build.gradle). The JDA dependency can be added as follows:
dependencies {
    implementation 'net.dv8tion:JDA:4.3.0_333'
}

Make sure to sync your Gradle project after adding the dependency.

Discord Bot Token: Obtain a Discord bot token by creating a bot application on the Discord Developer Portal (https://discord.com/developers/applications). This token is required to authenticate your bot with the Discord API.


Installation:


Clone the repository using the following command:e

$ git clone https://github.com/GAUTHAM09012004/DISCORDBOT_JAVA.git

Navigate to the project directory:

$ cd discord-bot

Set Up the Bot Token

Create a Discord bot application on the Discord Developer Portal (https://discord.com/developers/applications).

Obtain the bot token from the bot application's settings page.

Open the project in your preferred IDE (e.g., IntelliJ IDEA).

Locate the configuration file (config.properties) in the project directory.

Replace the placeholder <your-bot-token> in the configuration file with your actual bot token.

Build the project using Gradle:
$ ./gradlew build

Run the bot:
$ ./gradlew run

Alternatively, you can run the bot using your IDE's run configuration.
    
Usage:
    
Java,
JDA (Java Discord API),
Gradle,
IntelliJ IDEA,
Discord Developer Portal
    
Contributions: 
Contributions to the Discord bot project are welcome. If you would like to contribute, you can do so by opening an issue or submitting a pull request on the GitHub repository. You can report bugs, suggest new features, or provide improvements to the existing code. Your contributions can help enhance the functionality and overall quality of the bot. Make sure to follow any guidelines or instructions mentioned in the repository's CONTRIBUTIONS.md file, if available, to ensure a smooth contribution process.

License: 
The Discord bot is open-source and is licensed under the MIT License. The MIT License allows you to freely modify, distribute, and use the bot's code for personal or commercial purposes. It provides you with the freedom to adapt the code to your needs while providing some basic protections and disclaimers. It's important to review the LICENSE.md file in the repository for the specific terms and conditions of the MIT License that apply to the bot.
 
    
    
