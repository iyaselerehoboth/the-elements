package com.iyaselerehoboth.theelements.data.room.tables;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "elements")
public class Elements {

    private String atomic_mass;
    @PrimaryKey
    @NonNull
    private Integer atomic_number;
    private Integer atomic_radius;
    private String block;
    private Integer boiling_point;
    private String bonding_type;
    private String cpk_hex_color;
    private String crystal_structure;
    private String density;
    private Integer electron_affinity;
    private String electronegativity;
    private String electronic_configuration;
    private String facts;
    private String group;
    private String group_block;
    private String ion_radius;
    private Integer ionization_energy;
    private String isotopes;
    private String magnetic_ordering;
    private String melting_point;
    private String molar_heat_capacity;
    private String name;
    private String oxidation_states;
    private Integer period;
    private String speed_of_sound;
    private String standard_state;
    private String symbol;
    private String vanderwaals_radius;
    private String year_discovered;
    private String history;

    public Elements(String atomic_mass, @NonNull Integer atomic_number, Integer atomic_radius, String block, Integer boiling_point, String bonding_type, String cpk_hex_color, String crystal_structure, String density, Integer electron_affinity, String electronegativity, String electronic_configuration, String facts, String group, String group_block, String ion_radius, Integer ionization_energy, String isotopes, String magnetic_ordering, String melting_point, String molar_heat_capacity, String name, String oxidation_states, Integer period, String speed_of_sound, String standard_state, String symbol, String vanderwaals_radius, String year_discovered, String history) {
        this.atomic_mass = atomic_mass;
        this.atomic_number = atomic_number;
        this.atomic_radius = atomic_radius;
        this.block = block;
        this.boiling_point = boiling_point;
        this.bonding_type = bonding_type;
        this.cpk_hex_color = cpk_hex_color;
        this.crystal_structure = crystal_structure;
        this.density = density;
        this.electron_affinity = electron_affinity;
        this.electronegativity = electronegativity;
        this.electronic_configuration = electronic_configuration;
        this.facts = facts;
        this.group = group;
        this.group_block = group_block;
        this.ion_radius = ion_radius;
        this.ionization_energy = ionization_energy;
        this.isotopes = isotopes;
        this.magnetic_ordering = magnetic_ordering;
        this.melting_point = melting_point;
        this.molar_heat_capacity = molar_heat_capacity;
        this.name = name;
        this.oxidation_states = oxidation_states;
        this.period = period;
        this.speed_of_sound = speed_of_sound;
        this.standard_state = standard_state;
        this.symbol = symbol;
        this.vanderwaals_radius = vanderwaals_radius;
        this.year_discovered = year_discovered;
        this.history = history;
    }

    public String getAtomic_mass() {
        return atomic_mass;
    }

    @NonNull
    public Integer getAtomic_number() {
        return atomic_number;
    }

    public Integer getAtomic_radius() {
        if (atomic_radius == null) {
            return 0;
        }
        return atomic_radius;
    }

    public String getBlock() {
        if (block == null) {
            return "N/A";
        }
        return block;
    }

    public Integer getBoiling_point() {
        return boiling_point;
    }

    public String getCustomBoilingPoint() {
        if (boiling_point == null) {
            return "N/A";
        }
        return boiling_point + "\u2103";
    }

    public String getBonding_type() {
        if (bonding_type == null) {
            return "N/A";
        }
        return bonding_type;
    }

    public String getCpk_hex_color() {
        return cpk_hex_color;
    }

    public String getCrystal_structure() {
        if (crystal_structure == null) {
            return "N/A";
        }
        return crystal_structure;
    }

    public String getDensity() {
        if (density == null) {
            return "N/A";
        }
        return density;
    }

    public Integer getElectron_affinity() {
        if (electron_affinity == null) {
            return 0;
        }
        return electron_affinity;
    }

    public String getElectronegativity() {
        if (electronegativity == null) {
            return "N/A";
        }
        return electronegativity;
    }

    public String getElectronic_configuration() {
        return electronic_configuration;
    }

    public String getFacts() {
        return facts;
    }

    public String getGroup() {
        if (group == null) {
            return "N/A";
        }
        return group;
    }

    public String getGroup_block() {
        return group_block;
    }

    public String getIon_radius() {
        return ion_radius;
    }

    public Integer getIonization_energy() {
        return ionization_energy;
    }

    public String getIsotopes() {
        return isotopes;
    }

    public String getMagnetic_ordering() {
        if (magnetic_ordering == null) {
            return "N/A";
        }
        return magnetic_ordering;
    }

    public String getMelting_point() {
        return melting_point;
    }

    public String getCustomMeltingPoint() {
        if (melting_point == null) {
            return "N/A";
        }
        return melting_point + "\u2103";
    }

    public String getMolar_heat_capacity() {
        return molar_heat_capacity;
    }

    public String getName() {
        return name;
    }

    public String getOxidation_states() {
        if (oxidation_states == null) {
            return "N/A";
        }
        return oxidation_states;
    }

    public Integer getPeriod() {
        return period;
    }

    public String getSpeed_of_sound() {
        return speed_of_sound;
    }

    public String getStandard_state() {
        return standard_state;
    }

    public String getCustomStandardState() {
        if (standard_state == null) {
            return "N/A";
        }
        return standard_state.substring(0, 1).toUpperCase() + standard_state.substring(1).toLowerCase();
    }

    public String getSymbol() {
        return symbol;
    }

    public String getVanderwaals_radius() {
        return vanderwaals_radius;
    }

    public String getYear_discovered() {
        return year_discovered;
    }

    public String getHistory() {
        return history;
    }
}
