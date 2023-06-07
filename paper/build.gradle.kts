plugins {
	id("io.papermc.paperweight.userdev") version "1.3.8"
}

dependencies {
	paperDevBundle("1.19.4-R0.1-SNAPSHOT")

	compileOnly("net.civmc.civmodcore:CivModCore:2.3.5:dev-all")
	compileOnly("com.github.CivMC:RealisticBiomes:3.2.3")
	compileOnly("me.casperge.realisticseasons:RealisticSeasons:10.4.10")
}
