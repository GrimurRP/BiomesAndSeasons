plugins {
	id("io.papermc.paperweight.userdev") version "1.3.8"
}

dependencies {
	paperDevBundle("1.19.4-R0.1-SNAPSHOT")

	compileOnly("net.civmc.civmodcore:CivModCore:2.4.0:dev-all")
	compileOnly("net.civmc.realisticbiomes:RealisticBiomes:3.3.0")
	compileOnly("me.casperge.realisticseasons:RealisticSeasons:10.4.10")
}
