DISCORD BOT

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
