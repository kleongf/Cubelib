plugins {
    id("com.android.library")
    id("io.deepmedia.tools.deployer") version "0.18.0"
}

android {
    publishing {
        singleVariant("release")
    }

    namespace = "io.github.kleongf.cubelib" // TODO: change this
    compileSdk = 30

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

group = "io.github.kleongf" // TODO: change this
version = "1.0.0-beta.1" // TODO: change this

dependencies {
    implementation("org.firstinspires.ftc:RobotCore:10.2.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}

deployer {
    projectInfo {
        name = "Cubelib" // TODO: change this
        description = "Software library created by team 23641 Cuberobot" // TODO: change this
        url = "https://github.com/kleongf/cubelib" // TODO: change this
        scm {
            fromGithub("kleongf", "Cubelib") // TODO: change this
        }
        license(MIT)
        developer("Kevin Fong", "gevikfonn@gmail.com") // TODO: change this
    }

    signing {
        key = secret("MVN_GPG_KEY")
        password = secret("MVN_GPG_PASSWORD")
    }

    content {
        androidComponents("release") {
            emptyDocs()
            emptySources()
        }
    }

    centralPortalSpec {
        auth {
            user = secret("SONATYPE_USERNAME")
            password = secret("SONATYPE_PASSWORD")
        }
        allowMavenCentralSync = false
    }
}

