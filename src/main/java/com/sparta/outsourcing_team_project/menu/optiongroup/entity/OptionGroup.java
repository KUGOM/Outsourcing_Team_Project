package com.sparta.outsourcing_team_project.menu.optiongroup.entity;

import com.sparta.outsourcing_team_project.menu.entity.Menu;
import com.sparta.outsourcing_team_project.menu.optiongroup.option.entity.Option;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "option_group")
public class OptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_group_id")
    private Long id;

    @Column(nullable = false)
    private String optionGroupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();

    public OptionGroup(String optionGroupName, Menu menu) {
        this.optionGroupName = optionGroupName;
        this.menu = menu;
    }

    public void update(String optionGroupName) {
        this.optionGroupName = optionGroupName;
    }
}