package com.mycompany.dragon_treasure;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class Dragon extends Monster
{
    private static final int monsterId = 1;
     private static final String nameD = "Dragon";
    private static final String monsterDesc = "\n" +
"        \"                                                 .~))>>\\n\"+\n" +
"        \"                                               .~)>>\\n\"+\n" +
"        \"                                             .~))))>>>\\n\"+\n" +
"        \"                                           .~))>>             ___\\n\"+\n" +
"        \"                                         .~))>>)))>>      .-~))>>\\n\"+\n" +
"        \"                                       .~)))))>>       .-~))>>)>\\n\"+\n" +
"        \"                                     .~)))>>))))>> .-~)>>)>\\n\"+\n" +
"        \"                   )              .~))>>))))>> .-~)))))>>)>\\n\"+\n" +
"        \"               ( )@@*)          //)>))))))  .-~))))>>)>\\n\"+\n" +
"        \"           ).@(@@              //))>>))) .-~))>>)))))>>)>\\n\"+\n" +
"        \"           (( @.@).           //))))) .-~)>>)))))>>)>\\n\"+\n" +
"        \"           )) )@@*.@@ )      //)>))) //))))))>>))))>>)>\\n\"+\n" +
"        \"       (( ((@@@.@@          |/))))) //)))))>>)))>>)>\\n\"+\n" +
"        \" )) @@*. )@@ )         (\\\\_(\\\\-\\\\b |))>)) //)))>>)))))))>>)>\\n\"+\n" +
"        \" (( @@@(.@(@ .         _/`-` ~|b |>))) //)>>)))))))>>)>\\n\"+\n" +
"        \" )* @@@ )@*          (@)   (@) /\\\\b|))) //))))))>>))))>>\\n\"+\n" +
"        \" (( @. )@  ( @ .    _/ /      /  \\\\b)) //))>>)))))>>>_._\\n\"+\n" +
"        \" )@@ (@@*)@@.     (6///6)-   / ^  \\\\b)//))))))>>)))>> ~~-.\\n\"+\n" +
"        \" ( @jgs@@. @@@.  *@_ VvvvvV//  ^   \\\\b/)>>))))>> _.    `bb\\n\"+\n" +
"        \" ((@@ @@@*.(@@ .    - | o |' \\\\ (  ^   \\\\b)))>> .'       b`,\\n\"+\n" +
"        \" ((@@).*@@ )@ )       \\\\^^^/   ((   ^ ~)_ \\\\ /             b `,\\n\"+\n" +
"        \"(@@. (@@ ). `-'               (((   ^ `\\\\ \\\\ \\\\ \\\\ \\\\|      b `.\\n\" +       \n" +
"        \" (*.@*                       /(((( \\\\| | | \\\\              . b `.\\n\"+\n" +
"        \"                            / / ((((( \\\\ \\\\ / _.-~\\\\ Y,    b ;\\n\"+\n" +
"        \"                           / / / (((((( \\\\ \\\\.-~ _.`\\\" _.-~`, b \\n\"+\n" +
"        \"                           / / `(((((() ) (((((~ `,       b ;\\n\"+\n" +
"        \"                         _/ _/ `\\\"\\\"\\\"/ /'               ; b ;\\n\"+\n" +
"        \"                      _.-~_.-~       / /'         _.'~bb _.'\\n\"+\n" +
"        \"                      ((((~~        / /'        _.'~bb.--~\\n\"+\n" +
"        \"                                   ((((       __.-~bb.-~\\n\"+\n" +
"        \"                                           .' b .~~\\n\"+\n" +
"        \"                                           :bb ,' \\n\"+\n" +
"        \"                                            ~~~~\\n\");\n" +
"        \n" +
"        ";
    
    public Dragon (int damage, int healthPoints)
    {
        super(nameD, damage, healthPoints, monsterDesc, monsterId);
        
    }
   
    
}
