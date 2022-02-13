package com.example.demo.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CodigoMorse {
    @GetMapping("/{morseCod}")
    public String helloWorld(@PathVariable String morseCod) {
        //PROGRAMA CONVERSION MORSE A PALABRAS (SPRING)

        String morse = morseCod;
        morse = " ";
        String AbecedarioyNumeros = "abcdefghijklmnopqrstuvwxyz0123456789";
        String cadenaCA[] = new String[36];
        morseCod = morseCod.toLowerCase();
        String separador = "//";
        cadenaCA[0] = ".-"; 		//  ==A  -- .- ..-
        cadenaCA[1] = "-...";		//  ==B
        cadenaCA[2] = "-.-.";		//  ==C
        cadenaCA[3] = "-..";		//  ==D
        cadenaCA[4] = ".";		    //  ==E
        cadenaCA[5] = "..-.";		//  ==F
        cadenaCA[6] = "--.";		//  ==G
        cadenaCA[7] = "....";		//  ==H
        cadenaCA[8] = "..";		    //  ==I
        cadenaCA[9] = ".---";		//  ==J
        cadenaCA[10] = "-.-";		//  ==K
        cadenaCA[11] = ".-..";	    //  ==L
        cadenaCA[12] = "--";		//  ==M
        cadenaCA[13] = "-.";		//  ==N
        cadenaCA[14] = "---";		//  ==O
        cadenaCA[15] = ".--.";	    //  ==P
        cadenaCA[16] = "--.-";	    //  ==Q
        cadenaCA[17] = ".-.";		//  ==R
        cadenaCA[18] = "...";		//  ==S
        cadenaCA[19] = "-";		    //  ==T
        cadenaCA[20] = "..-";		//  ==U
        cadenaCA[21] = "...-";	    //  ==V
        cadenaCA[22] = ".--";		//  ==W
        cadenaCA[23] = "-..-";	    //  ==X
        cadenaCA[24] = "-.--";	    //  ==Y
        cadenaCA[25] = "--..";	    //  ==Z
        cadenaCA[26] = "-----"; 	//  ==0
        cadenaCA[27] = ".----"; 	//  ==1
        cadenaCA[28] = "..---";	    //  ==2
        cadenaCA[29] = "...--";	    //  ==3
        cadenaCA[30] = "....-"; 	//  ==4
        cadenaCA[31] = ".....";	    //  ==5
        cadenaCA[32] = "-....";	    //  ==6
        cadenaCA[33] = "--...";	    //  ==7
        cadenaCA[34] = "---..";	    //  ==8
        cadenaCA[35] = "----.";	    //  ==9
        String oracion[] = morseCod.split(" ");

        int max = oracion.length;
        for  (int i = 0; i < max; i++){
            for (int j = 0; j < 36; j++)
                if (oracion[i].equals(cadenaCA[j])) {
                    morse = morse+AbecedarioyNumeros.charAt(j);
                    break;
                }
        }
        morse = morse.substring(1,morse.length());


        return "Los caracteres en morse que tu insertaste son:  "+morseCod +" lo cual su traduccion es:  "+morse;
    }

}
