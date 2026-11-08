package com.example.startechcomputer.data

object DataSource {

    // PILIHAN PROSESOR
    val processors = listOf(

        ComponentOption(
            "Intel Core i3-10100f",
            1_000_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Athlon 3000G",
            850_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Pentium Gold G7400",
            1_300_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Ryzen 5 3400G",
            4_000_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Core i5 12400F",
            2_700_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Ryzen 7 3700X Matisse AM4",
            6_700_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Core i7-11700",
            4_800_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Ryzen 5 5600X",
            2_800_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Core i9 9900KF",
            5_900_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Ryzen 9 3900X",
            6_000_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Core i9-10900K",
            7_700_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Ryzen 7 5700G",
            3_300_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Core i5-11500",
            3_900_000,
            "Intel"
        ),

        ComponentOption(
            "AMD Ryzen 9 5950X",
            8_800_000,
            "AMD"
        ),

        ComponentOption(
            "Intel Core i7-12700",
            5_700_000,
            "Intel"
        )
    )


    // PILIHAN HDD DAN SSD
    val storage = listOf(

        // HDD
        ComponentOption(
            "Seagate 3.5 500 GB BarraCuda",
            620_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 3.5 1 TB BarraCuda",
            1_900_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 3.5 2 TB BarraCuda",
            2_100_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 3.5 4 TB BarraCuda",
            3_900_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 3.5 6 TB BarraCuda",
            4_100_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 3.5 8 TB BarraCuda",
            5_400_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 3.5 10 TB BarraCuda",
            7_700_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 2.5 1 TB BarraCuda",
            1_190_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 2.5 2 TB BarraCuda",
            2_480_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 2.5 4TB BarraCuda",
            2_980_000,
            "HDD"
        ),

        ComponentOption(
            "Seagate 2.5 5TB BarraCuda",
            3_680_000,
            "HDD"
        ),


        // SSD
        ComponentOption(
            "Intel SSD 670p 512GB M.2",
            700_000,
            "SSD"
        ),

        ComponentOption(
            "Intel SSD 670p 2TB M.2",
            1_800_000,
            "SSD"
        ),

        ComponentOption(
            "Intel SSD DC-P4510 1TB",
            4_500_000,
            "SSD"
        ),

        ComponentOption(
            "Kingston XS1000 Portable SSD 1TB",
            5_350_000,
            "SSD"
        ),

        ComponentOption(
            "Kingston XS1000 Portable SSD 2TB",
            8_900_000,
            "SSD"
        ),

        ComponentOption(
            "Kingston XS2000 Portable SSD 2TB",
            11_400_000,
            "SSD"
        ),

        ComponentOption(
            "Sandisk 320 SATA SSD 250GB",
            1_400_000,
            "SSD"
        ),

        ComponentOption(
            "Sandisk 320 SATA SSD 500GB",
            2_100_000,
            "SSD"
        ),

        ComponentOption(
            "Sandisk 320 SATA SSD 1TB",
            4_150_000,
            "SSD"
        ),

        ComponentOption(
            "Sandisk 320 SATA SSD 2TB",
            7_500_000,
            "SSD"
        )
    )


    // PILIHAN UKURAN MONITOR
    val monitors = listOf(

        ComponentOption(
            "Monitor 19 Inch",
            650_000,
            "Monitor"
        ),

        ComponentOption(
            "Monitor 22 Inch",
            1_100_000,
            "Monitor"
        ),

        ComponentOption(
            "Monitor 24 Inch",
            1_850_000,
            "Monitor"
        ),

        ComponentOption(
            "Monitor 27 Inch",
            3_400_000,
            "Monitor"
        ),

        ComponentOption(
            "Monitor 31 Inch",
            5_700_000,
            "Monitor"
        )
    )


    // PILIHAN VGA
    val graphics = listOf(

        ComponentOption(
            "ZOTAC GAMING GeForce RTX 3050 Twin Edge OC",
            3_890_000,
            "VGA"
        ),

        ComponentOption(
            "MSI GeForce RTX 5060 Shadow 2X OC",
            6_980_000,
            "VGA"
        ),

        ComponentOption(
            "ASUS Dual Radeon RX 7600 EVO OC Edition",
            5_180_000,
            "VGA"
        ),

        ComponentOption(
            "POWERCOLOR Hellhound AMD Radeon RX 9070 XT",
            13_850_000,
            "VGA"
        ),

        ComponentOption(
            "Palit GeForce RTX 5050 StormX",
            6_100_000,
            "VGA"
        ),

        ComponentOption(
            "Sapphire Nitro+ AMD Radeon RX 7800 XT OC",
            9_880_000,
            "VGA"
        ),

        ComponentOption(
            "ASRock AMD Radeon RX 9060 XT Steel Legend OC",
            9_350_000,
            "VGA"
        ),

        ComponentOption(
            "Gainward GeForce RTX 5070 Python III",
            12_700_000,
            "VGA"
        ),

        ComponentOption(
            "AORUS GeForce RTX 5080 MASTER",
            31_100_000,
            "VGA"
        )
    )
}