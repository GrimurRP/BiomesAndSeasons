plugins {
	`java-library`
	id("net.civmc.civgradle.plugin")
	id("io.papermc.paperweight.userdev") version "1.3.1"
}

civGradle {
	paper {
		pluginName = "BiomesAndSeasons"
	}
}

dependencies {
	paperDevBundle("1.18.2-R0.1-SNAPSHOT")

	compileOnly("net.civmc.civmodcore:paper:2.0.0-SNAPSHOT:dev-all")
	compileOnly("net.civmc.realisticbiomes:RealisticBiomes-paper:3.0.0-SNAPSHOT")
	compileOnly("me.casperge.realisticseasons:RealisticSeasons:7.44")
}
