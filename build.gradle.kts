

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    id("com.android.application") version "8.5.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("jacoco")

}


jacoco {
    toolVersion = "0.8.11"
   // reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

tasks.jacocoTestReport {
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("reports/jacocoHtml")
    }
}