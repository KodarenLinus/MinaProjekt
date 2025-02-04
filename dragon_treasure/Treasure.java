/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dragon_treasure;

/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class Treasure extends Item
{
    private static final int goldValue = 60;
    private static final int itemId = 2;
    private static final String nameT = "Treasure";
    private static final String itemDesc = "\n" +
"            \"               _       .--.\\n\" +\n" +
"            \"                  _  -'_:-'||\\n\"+\n" +
"            \"             _  -'_.-::::' ||\\n\"+\n" +
"            \"         _:'_.-::::::'     ||\\n\"+\n" +
"            \"       .'`-.-:::::::'      ||\\n\"+\n" +
"            \"      /.'`;|:::::::'       ||_\\n\"+\n" +
"            \"     ||   ||::::::'      _.;._'-._\\n\"+\n" +
"            \"     ||   ||:::::'    _.-!oo @.!-._'-.\\n\"+\n" +
"            \"     \\'.  ||:::::.-!() oo @!()@.-'_.||\\n\"+\n" +
"            \"       '.'-;|:.-'.&$@.& ()$%-'o.'\\\\U||\\n\"+\n" +
"            \"         `>'-.!@%()@'@_%-'_.- o _.|'||\\n\"+\n" +
"            \"          ||-._'-.@.-'_.-' _.-  o |'||\\n\"+\n" +
"            \"          ||=[ '-._.-\\\\U/.-'    o |'||\\n\"+\n" +
"            \"          || '-.]=|| |'|        o |'||\\n\"+\n" +
"            \"          ||      || |'|         _| ';\\n\"+\n" +
"            \"          ||      || |'|     _.-'_.-'\\n\"+\n" +
"            \"          |'-._   || |'|_.-' _.-'\\n\"+\n" +
"            \"          '-._'-. || |' `_.-'\\n\"+\n" +
"            \"               '-.||_/.-'\\n\"\n" +
"        ";
    
    public Treasure ()
    {
        super(nameT, itemDesc, itemId);
    }
    
    public int getGoldValue()
    {
        return goldValue;
    }
}
