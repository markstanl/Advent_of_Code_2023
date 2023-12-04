
public class D01_5 {

  /**
   * similar to day 1 part 1, this method takes a string, puts it into a character array, finds the
   * first and last instance of a number (this is either a numerical digit, or a string representation of
   * a non-zero digit), and combines the two digits respectively to make a two digit number, then 
   * returns that number as an integer
   * 
   * assumes valid implementation
   * @param input    the string to be iterated through
   * @return         the integer 
   */
  private static int toTrebuchetVal(String input) {
    char[] charArray = input.toCharArray();

    int minIndex = -1;
    int maxIndex = 1;
    int count = 0;

    for (char character : charArray) {
      if (isCurrentCharNum(charArray, count)) {
        if (minIndex == -1)
          minIndex = count;
        maxIndex = count;
      }
      count++;
    }

    String num = Integer.toString(indexToNum(charArray, minIndex))
        + Integer.toString(indexToNum(charArray, maxIndex));


    return Integer.parseInt(num);
  }

  /**
   * Private helper method. Given we know that a number exists at the given index, this method
   * returns the value of that number
   * 
   * @param charArray the array of characters that we are referring to
   * @param index     the index of the initial character of the number
   * @return the integer value of the number starting at that index number in the character array
   */
  private static int indexToNum(char[] charArray, int index) {
    
    char currentChar = charArray[index]; //quick variable for the array
    
    //just goes down the list of tests
    if (Character.isDigit(currentChar)) return Integer.parseInt(Character.toString(currentChar));
    
    //checks if the index is an instance of a string digit
    if (isStringNum(charArray, index, "one")) return 1;
    
    if (isStringNum(charArray, index, "two")) return 2;
    
    if (isStringNum(charArray, index, "three")) return 3;
    
    if (isStringNum(charArray, index, "four")) return 4;
    
    if (isStringNum(charArray, index, "five")) return 5;

    if (isStringNum(charArray, index, "six")) return 6;
    
    if (isStringNum(charArray, index, "seven")) return 7;
    
    if (isStringNum(charArray, index, "eight")) return 8;
    
    if (isStringNum(charArray, index, "nine")) return 9;
    
    //for iscurrentcharnum, if all cases pass and this returnns -1, we know the current character
    //is not a number
    return -1;
  }

  /**
   * checks if the current represents the start of a number, or is a digit
   * @param charArray   the current character array of the string we are testing
   * @param index       the index of the first character we want to check
   * @return        true if the index represents the start of a string number or is a digit
   */
  private static boolean isCurrentCharNum(char[] charArray, int index) {
    //simply need to call the indexToNum
    return indexToNum(charArray, index) != -1;
  }

  /**
   * internal logisitics for figuring out if the starting index represents a string number
   * @param charArray    the character array for the string to be iterated through
   * @param index       the index of the initial character we wish to see if the string is a num
   * @param num         The string representation of a number ex. "one"
   * @return            true if the characters match to the given string
   */
  private static boolean isStringNum(char[] charArray, int index, String num) {

    //iterates through all characters in the number string
    for (int i = 0; i < num.length(); i++) {
      //if the index ebcomes equal to or greater than the length, it will throw an index out of bounds
      // so return false
      // otherwise, check that the character at the current node is the same as the character at the
      //current node of the string, then iterate through 
      if (charArray.length <= index + i || charArray[index + i] != num.charAt(i)) {
        return false;
      }
    }

    //if it all passes return true
    return true;
  }

  /**
   * main method for test. gets the string, breaks it up into strings to pass through, iterates
   * through all the strings, then sums their return values
   * @param args
   */
  public static void main(String[] args) {
    String values = "2xjzgsjzfhzhm1\r\n" + "qhklfjd39rpjxhqtftwopfvrrj2eight\r\n" + "95btwo\r\n"
        + "lfsqldnf3onenplgfxdjzjjnpzfxnineseven\r\n" + "five7fouronesevenpfsrmszpc\r\n"
        + "xcsfkjqvln2tpm\r\n" + "ncjtcdb625two9\r\n" + "6srtj3gfghkdtmfzseven\r\n"
        + "three4fournineone\r\n" + "pcpsxmkhdgsix25six6ngzsqzdcrb\r\n"
        + "1sixdzhbjvnvgcxmsrlkb9xbjk7t2\r\n" + "dsxnfkjn2vtwofivethree2\r\n" + "qfbp2tpgvsxm\r\n"
        + "kvbhsseven2rkbllhrhvsevenfour2vf\r\n" + "bqbtzbtt3\r\n" + "ninek6\r\n"
        + "3fivebvqhvhlvz\r\n" + "two68jxfnqlzfkninenine8\r\n" + "vhckhhhb2sixtftjtdjf2nine\r\n"
        + "4jc\r\n" + "3sevenxlxfnpk\r\n" + "5sjfive\r\n" + "c8bvlkdq283rqfftj\r\n"
        + "8eight1threehhvmnlft\r\n" + "4sixmfcronelzcpnfourlgdbkgt\r\n" + "hntcjmppp9fmntwokx2\r\n"
        + "24mkgr6mx9n4\r\n" + "cksfkrdmdcmnbmkgk3two4\r\n" + "twosixthreefivelq3nine\r\n"
        + "njmrtr6fmldninevcbtxr42\r\n" + "eightfrdrczdxrcrfxh6\r\n" + "8sevenonefmfqhtx8lk\r\n"
        + "lnoneight8twodg\r\n" + "tszrcb7tvvhfive4\r\n" + "nknphprtv67fivehqlfournine2jk\r\n"
        + "9eightszgdhftggrktkzbsmnhtwonekh\r\n" + "1onefzkgf2two417\r\n" + "77fivepsmmpp\r\n"
        + "bnine7vmttgmdskc\r\n" + "6tnsixclbvkhmsp\r\n" + "ggreightwo1mnsbzmxsdcdrhhg5one\r\n"
        + "ninetwo6qtbklgb2\r\n" + "four8fmfxmr\r\n" + "threetxfrsevenvfdgrtsixtwofsq7\r\n"
        + "hqxlseven53\r\n" + "vxqq24eight6\r\n" + "7psxpgxmkpzkzeight3\r\n" + "9four7\r\n"
        + "stwoone4eightwoj\r\n" + "one38\r\n" + "9cjlrgrgpfjeighteightdcpjhzbjqcdthree\r\n"
        + "rqfone2\r\n" + "dvkxhvkgxcfivescjcnqqnnine2tthreecptkgxmzjsbzdrhk\r\n"
        + "5lhprmg8two7two3\r\n" + "5lvtg5sevennine2zrrmghf4seven\r\n"
        + "fourfive97sevensevensixcsffnlcbtjk\r\n" + "onesixoneninesixnbkf5xpsgsmpvdsdsqdvpjjzp\r\n"
        + "nineb321mgkpqjqjqh\r\n" + "seven2cstttkvkmpssflkxjmbnvthreefour\r\n"
        + "six1bmcjbhdgqm6kgzsxbgdqnjqf3four6\r\n" + "zchkfjxsllkncz175\r\n" + "vsveightwo8\r\n"
        + "fourbtrnfdp2four5\r\n" + "13dtf8769\r\n" + "6qfvvdqdrtstwothree4seven8vszpseven\r\n"
        + "7rgzpxfbczk1fivetwo4two9nine\r\n" + "3sksmfxn\r\n" + "16ninetwonqqmptq\r\n"
        + "9five4fckzssxsvpzbvlktjzcninethree\r\n" + "3threel889bvbcgvl\r\n"
        + "threetzzjntxlsd2klrjfnbg87\r\n" + "3two3qrrdbkbk\r\n" + "29oneightt\r\n"
        + "7mkpfchstjt7mshqht4fivesix\r\n" + "tvmqndvsix875nine8\r\n" + "vg7477ninecpnrvnine7\r\n"
        + "seveneightmknlqjlstx4zjjrpbhjhnnc8\r\n" + "8qklthreetwo7tlmrfzvtwo7zvccc\r\n"
        + "6one1dpstqpmfbhst\r\n" + "sixfourfourseven6rzdkfour\r\n" + "6eighttbltmntb8\r\n"
        + "seven72cqslvzpgj\r\n" + "jpvrsgfhtwo5nfc1cgxdrdrbfnseven\r\n"
        + "four1ninezlhqxtsgfzsevenhspvmxrtztzgtmseven5\r\n" + "foursixzjvgjgsevensvkd5\r\n"
        + "seven121fivefgxhdfive\r\n" + "twoh8\r\n" + "ghhtttxqgr95\r\n" + "zkpklcjbjlr2\r\n"
        + "nine2mtrdcbrbntrdqninevbkbfg35lnpx\r\n" + "nineninesix68pcvsdnns\r\n" + "rf16one7\r\n"
        + "seven276\r\n" + "sixseven1\r\n" + "qjxseven9six\r\n" + "7c9xvhgmpf41\r\n"
        + "dlzpvdpxseven9nine\r\n" + "mlmlqrpn4twofivesbmhdbcsixtwo\r\n"
        + "ld74txfzksr5qconenine\r\n" + "six7djcdrtk7chktrh88\r\n" + "2seven7jtrbhznt\r\n"
        + "1eighthnhchsevenfive\r\n" + "qdhscpeight8\r\n" + "12gnxzzm\r\n"
        + "k7fourmhcfkggt8919np\r\n" + "8zljspvnmlx6four\r\n" + "36twofivethreeptbdrfqzbz7qbjm\r\n"
        + "bxkbjbzgone3ldhlnhxfcf7btkktspxrtqkxqfdmlqgqvgclb\r\n"
        + "sevenfourmdrxseven2z2fiveone\r\n" + "8bbprzqrqn\r\n" + "twofivethree95mpqclhfkzlsix\r\n"
        + "gpfjflrkc96tmsix6dxjnfive\r\n" + "qzeight6\r\n" + "five5zlthgqjntwotqmnnsd\r\n"
        + "eight6nbpvfour4kzkvbzrxcmkh\r\n" + "fdkrxdckqbpsklz64fourones8\r\n" + "5qpldkhltl\r\n"
        + "27xldkbqbnmrrbqkhmksvk\r\n" + "pjoneightknpcgkkv7cbknrhfdmtdm8\r\n"
        + "432xsixvvktflzxone\r\n" + "35fouronemzzszfqppllgchsjjnine\r\n"
        + "qgcnzcbvsxbtn6lthreenineone\r\n" + "two2fourkdgbfb\r\n"
        + "fzkmbtvnvj5bzfgvxv3nineknpqzznzmf\r\n" + "9mkqtmlnpzt282dgkmvlsonefourthree\r\n"
        + "mcqhpkhonethreeninesevenfdsggqnlfcnrft3frqzkscft\r\n" + "847\r\n"
        + "gsxvvr6tghfbxxghgv6lplf\r\n" + "fqzgkxkbmkpbhpvpdprmlhsngc5\r\n"
        + "qeightwo2threecrjjtv9fourbthree\r\n" + "2eightdcbgfdqzk\r\n"
        + "fourtwothree5tdzpzfxkpjmlkzzrf\r\n" + "seven633\r\n" + "8mldn\r\n"
        + "eightmg7dvjzbngkxmnxdctjtdffive97zpjrjqvp\r\n" + "sixfournineone38eighteight\r\n"
        + "8mngs412\r\n" + "3fivefourtwo7five\r\n" + "7sevenjfkcf7rvone8xjdvsc\r\n"
        + "tljcrzngfdsqctfour6hsnljsxrqdzd\r\n" + "csix7hnkhds4four67\r\n"
        + "3cxrlqcnseven4twox3\r\n" + "rtwonerxcnpqdnzksvzmmndcjlzq2nine6ntfzjdqnrjeight\r\n"
        + "zbqgrvvvblggbghtfx98\r\n" + "three2zcpspgtq77vqtgpcxkvq8\r\n" + "94zksixnvbxrllxln\r\n"
        + "1eightrctknxkmv9jtwoeight\r\n" + "2onenine5eight58\r\n" + "four2five\r\n"
        + "6fourfiveeight\r\n" + "pbfourlzdl4\r\n" + "4onejrltvhxprhlzctrqzbz5fourseven6\r\n"
        + "hlsdjlleightdcmdj8jdg\r\n" + "eightbfkgvbxxm6\r\n"
        + "sixseven9hmhchsmqhhtrdftcfivetz\r\n" + "mq4five2fsdhzn\r\n"
        + "ceight3mncgnineeight8dkqrjjtmc\r\n" + "onefour7eightsix\r\n"
        + "seven4fqsjk38fhbmn9fgzzcc\r\n" + "9cmb5ninenjsppthpnine5\r\n"
        + "qghtvpsqpxptoneljvstwo8lpqcbgtqvjmpq\r\n" + "onelq85dlqpx8\r\n"
        + "1threetzsxqtndvhqn\r\n" + "lqdvkonebqjqj9\r\n" + "3six6\r\n" + "9two9sixeight776\r\n"
        + "scrrprfkblkplgqzzqb2\r\n" + "18vcrhxb4b\r\n" + "three8nine\r\n"
        + "1khkncj8fivefourthree2\r\n" + "ninetwo8tbbsfmkqtt51five\r\n" + "66one88\r\n"
        + "ninempgbhpm6seven34\r\n" + "eightthreetwo4threetwo\r\n"
        + "vvpqkdonesevendvfrgmhhlsix91threethree\r\n" + "vbskcncpjxtdhqlcone6kgqpz\r\n"
        + "54lmnnqsrm73\r\n" + "5mqnmvcbqnz82ninethree\r\n" + "47teightthreehrhtdndrk\r\n"
        + "fft2foursrdhxkzfourv\r\n" + "tbeight48759eight9twonenl\r\n"
        + "3sfkvkmvbbm9four9cbjzgllfl\r\n" + "sixqhxeightone7tlsd\r\n" + "22zmllbhcptwo\r\n"
        + "dqxdjrkmnvkbsxc3ztbseven\r\n" + "oneeight6dcphmnrfltfour\r\n" + "mgxzcfsevenfour4six\r\n"
        + "sixb8six34gqjtlcq\r\n" + "fiveseventhreexfblvxgkplvbrgpfive1onesix\r\n"
        + "one3mgqphj5\r\n" + "7fpzxmmxgnb5\r\n" + "jbshclzone3oneseven117dkzzdxdd\r\n"
        + "56five1\r\n" + "jeightwo1ninemxtvgl717pbv1mqs\r\n" + "3six36\r\n" + "35mlzjsgxxtg\r\n"
        + "hmmjgonehjqdcqkh1gskjrmfour7\r\n" + "eightfiverqbb3\r\n"
        + "sixtdkfbglhbjbvthreejsd8tglkrsfktcjt\r\n" + "1eight2mgxrgbbb3\r\n"
        + "zzqxvtthreepf3eighttwoonefive\r\n" + "vjnxhl4threetwokj\r\n"
        + "oneqddgbbqtzsonenxkeightvx7\r\n" + "nine24\r\n" + "ftwone2\r\n" + "53twonehx\r\n"
        + "two7three4fourhbgninenkvxjjsz\r\n" + "7five62ninefour\r\n" + "53nine7lqthree4\r\n"
        + "1six1jn\r\n" + "five5drcjvbgdxzonefourfjdkfive\r\n"
        + "6onecfninesqfdtxmdhmfvlhbsjv9eight\r\n" + "5dqmfmqbdfdjvpl\r\n"
        + "qxkqfjshdone2zrmdsts\r\n" + "1qrvnf8zvfour\r\n" + "dht2\r\n"
        + "4twoqdrshn87vxldzvnkn1five\r\n" + "4nineh\r\n" + "zctqdcfbseven6three58lzscrpsbb2\r\n"
        + "fzmndhssmm3jdzlfourshjkmjkv53gvssnvzsz\r\n" + "five2qkxtfkj3sixshpnzdcjhlcmksnv\r\n"
        + "bskcmljnq69\r\n" + "psxkxqztb3xsctsk6qvldjdzzqmgqcxncx2btqxh\r\n"
        + "onetwosixttghndtzx8\r\n" + "8twocmnfmslsheighthtxsgjddm\r\n"
        + "fnvkqndfqmhgscnvq31kvvftxbzhtgzxqtngvqseven\r\n"
        + "7sevenkhhvtvsbrvcvm8zksvgcfrkgfourtzjvpqstckmmlzz\r\n" + "7hkfiveeightpjhone\r\n"
        + "8zptwoonemrninefive3spxrlhr\r\n" + "3qvjknqcnngpkninecgsbp3sevenfnpvrcltj\r\n"
        + "qztwo8678\r\n" + "bxkj959dntcpzv\r\n" + "4one4\r\n" + "lstwone347nine\r\n"
        + "ff79krfbjttqp4seven1\r\n" + "gjtlbgxdqt7eightsix\r\n" + "8fivefour82threetwo\r\n"
        + "1zjxthree4\r\n" + "szgx6fivefour12\r\n" + "557dspnfzhmlh\r\n" + "5hnfour\r\n"
        + "847zzkrtjlb\r\n" + "82six\r\n" + "xlnhrcksv3fourzl\r\n" + "2ninetwo8ninelhnsbseven9\r\n"
        + "ccseightwo8fiveonetwo5onegkhlg\r\n" + "eightp2onegrmfsnine5one\r\n"
        + "4five9xnmlldfive\r\n" + "five636\r\n" + "fivesix29\r\n" + "34dsbtmlhgggzkqxs7\r\n"
        + "twothreesmgjch93mcdndsn\r\n" + "cmnmtzjnmtggseven1tjsshnktffive72\r\n" + "7xcbpsix6m\r\n"
        + "7fourthree\r\n" + "7cxnzthree\r\n" + "5eightthree3lpvlfk\r\n" + "4rdnp\r\n"
        + "one6gmpjfouronettbbjdqsxn\r\n" + "6xtcv\r\n" + "dpspd1cb2onegxsgdtcsix\r\n"
        + "1eightpseven\r\n" + "ntczqmrclm2\r\n" + "six7nineeight1\r\n" + "qrndlfour9bhbmlgj6\r\n"
        + "52vhnxvngjjkzt\r\n" + "nine8six\r\n" + "3seventhreesixfpmpbjninesix\r\n"
        + "seightwoseven4sevenppdnk7\r\n" + "lnxeightbhxfmdrxcbjzx9sixnine\r\n"
        + "8ptdmjrd21zrnt1one\r\n" + "one1dmbfournine2\r\n" + "25five748\r\n" + "266eightwom\r\n"
        + "zxfxjn32threelxmqnlcvnknzbn3\r\n" + "lqmjm2onezseven\r\n" + "sphlhbbz14sixtwosix\r\n"
        + "sixr9llqxb4\r\n" + "tnnhlmsix314mqvdlxfour4\r\n" + "threenjxgtthreethreeeight14one\r\n"
        + "1fivetwo\r\n" + "hhhtkpvhvg8\r\n" + "31cslxxzgbktjtwotrzs1one\r\n" + "twoseven9\r\n"
        + "4fivenine9332\r\n" + "six35nineeightwok\r\n" + "nine9fpxgqjrftwovhldfflqthree\r\n"
        + "434four5threetpcs\r\n" + "ql52kzzgnsgll\r\n" + "onex5145\r\n" + "gsppnkx1\r\n"
        + "22six\r\n" + "zjbbqnbhsdfourmk19sixone\r\n" + "six3onesevensixvnsixone7\r\n"
        + "seventhreefive8\r\n" + "four62four7eightseventwo\r\n"
        + "2three5jtzmtxhqxhsixxlkmptshb\r\n" + "five3lklnccst1dstgvnprktgcnseven\r\n"
        + "sevenfour52\r\n" + "hfxkkbcfpcgzfqsv1three68three\r\n" + "lnqrcdpglf2ksqddhp\r\n"
        + "13onenbmqvpqsbbf\r\n" + "1bfive\r\n" + "1dmnlscgvfdqrf\r\n" + "bvtwonettkzzxpb4\r\n"
        + "5two2t7\r\n" + "t7djkh\r\n" + "63t86nlhfgqgnrghqone1\r\n"
        + "one89eightlmztkcjjnonefive\r\n" + "7twosjmcrlcfqr29lfkrjz\r\n" + "1nine5four\r\n"
        + "xxjbmsvfxb8\r\n" + "nxvrvcqkbseven99rbzbdp641\r\n" + "56fdpx\r\n"
        + "skszhkqdtonesixth5eight\r\n" + "ninetwo8jqbtwokbhzvv4fiveoneightxb\r\n"
        + "1threemfcblxjljdtone\r\n" + "fsfgncxvcmszn2pzspkkgqvfxlnbzgjr1\r\n"
        + "rrxhnslrkeightgcsbcgdbkplzxbmmlxsn5sfp66\r\n" + "foureight3\r\n"
        + "5rplrmrjtjcfnct9sixfourzptmffrpthree\r\n" + "mld6ztzninesixfour4\r\n"
        + "twohbbxmthljpkqthtcgtt8\r\n" + "ltvgmqgsix89\r\n" + "6khclqhcvdz24eightseven\r\n"
        + "6prb\r\n" + "nhsjqtnk6bqzhzvldlcgsmkq1twobfqzm\r\n"
        + "tfivehmdtxqlsevenzxt1ckjbnttgqctwo4\r\n"
        + "ghnjjmtlvfive9znltjfskfnl3vdcjkvqcdplvdmckmfgxq\r\n" + "ztvvbbjx3\r\n"
        + "6jhsrszlpsh\r\n" + "4fhtrctvrgmfhdjqvqp8sixnnftggrzlgs2\r\n"
        + "bvlqxnjbbjgtfpslpspvpl7jsjlrdfiveeight88\r\n" + "fsvcxvlc74sevenltx37sevenlbq\r\n"
        + "fourfivetgkqz5cgj4\r\n" + "cnrjtfvht74nptvh\r\n" + "oneldnoneone745dhvqnvmlfj\r\n"
        + "2trhmdcpnreight\r\n" + "dshghlkjzh1kv\r\n" + "threexzkssrxlzzpxsjzbbtthree7\r\n"
        + "eightdsqrdllssxv7sevendttwo3three\r\n" + "stz6five9four\r\n" + "jfbfgvfgmvlhjv94\r\n"
        + "rcncncfcqsevenjdrtctbbsznpct48cbbxseven\r\n" + "ninevjxzk2two\r\n"
        + "1qgdcpslvqhjzbgtsbnzcd\r\n" + "kmlzbndds8fivegfdgpfivetwo63\r\n"
        + "66mkeightnine1rvfnine4\r\n" + "nine82\r\n" + "58ntpkdssixnntjlgfkxq\r\n"
        + "2jxqttctsxthreepnxsfive\r\n" + "fivekvfkqpc28foursixptgbpfm6\r\n"
        + "6twofourslqbzlcsmf\r\n" + "five4vmdl\r\n" + "thx5six\r\n"
        + "5hfnsqhvcfgckcseven3jgdtkkv\r\n" + "seven6eight65five99\r\n"
        + "hplrgdqrjtonesevenseven4z65eight\r\n" + "khkts8hcsfvhvqjv9eightnine48\r\n"
        + "pqxztthreeninelxhcxkjclk2\r\n" + "sixrmfpj6nine4zx\r\n" + "9xtvxkxpjv9\r\n"
        + "cmtggbrckmmzffncttxsevenhphmhfgjsr85\r\n" + "83s4\r\n" + "26fivefivethreemstzpncmhfm\r\n"
        + "87eightfourgvmmfbknineone\r\n" + "bdxg2zszhcgtvtseventhmbvfive\r\n" + "zeight8\r\n"
        + "eight78dcnq4jtz\r\n" + "67csrthree\r\n" + "3vqxtwonerts\r\n" + "1five3\r\n"
        + "sevensixfournineksxkz9bkbgcrjjjhnineeight\r\n" + "8seven29\r\n" + "9394\r\n"
        + "pkqxvl9vbjmqblrksjqcshpzpfrfouroneeightnine\r\n"
        + "heightwolgpplrbnhrgdkrk25crttkkzkbt\r\n" + "6659eighttwoone\r\n" + "55lzqzng2dmtpq45\r\n"
        + "512gpmqpsqfive9eight\r\n" + "eightsnxz58zrbh8fiveeight\r\n" + "six893ninerrxzj\r\n"
        + "twoflrzzcgninefqqlmmzzqgnjrcxcfour5ninetlcmc\r\n" + "tmfkbgcssdcmkthmx1seven\r\n"
        + "6three9fourmdpzj\r\n" + "mgprpn68\r\n" + "xssxrtpntlkppxp958rzd2nine8\r\n"
        + "fx15twoeighttfjlcglnbptwo66\r\n" + "threeseven522\r\n" + "xrjpstjr2\r\n"
        + "6eight1742oneighthhj\r\n" + "1ddfkgjrxfzrhnxtnvfqxdv4\r\n"
        + "8hlcxdpkrnrgfzmsschlhcbndkcvdszgqntl\r\n" + "five154sixfourqgffh\r\n"
        + "5rsvtzgrvq1slrlgqksone6lns\r\n" + "92sevenk3xfrvgddsthree4\r\n" + "rctlcz67\r\n"
        + "2nmrbhnzpf7\r\n" + "bjmssix1sevenfour4\r\n" + "744ninefivefivejjcnpgrqxtrctwo\r\n"
        + "r4five4\r\n" + "16two2\r\n" + "threefn8\r\n" + "3gmsrqtjm\r\n"
        + "one8tmlnlqvgfone5fivefive\r\n" + "1spllmone9three1xsssk5\r\n" + "6rlqqblbrxh8\r\n"
        + "41qqccnsevengbbrpgcqggtlhtzqcfqzhtx\r\n" + "hzfivethreenine2\r\n"
        + "sixeightvcm4lngvkdlpz6dstz\r\n" + "twoeight34tv1\r\n"
        + "tgqc6fqsftwoninexncjnrtcgcbrxdmnine\r\n" + "8one27ninerjt3seven\r\n"
        + "1sjvxlzszhhsix\r\n" + "2xxmpjsfbr\r\n" + "7eight5eight5bzgdpkkpgrn\r\n"
        + "twozcrxdsix1lrxltrhvznine7twoone\r\n" + "8qlfive8nlmthree39\r\n" + "4five5five7671\r\n"
        + "4fiveqtrngqtbpd74\r\n" + "vbccfjhjndeight1h\r\n" + "8kfzchkdvfgvlhqzfgseven\r\n"
        + "6ninexrxsvlmmzrsevenjhzzggfcxqrvfjtnjctveight9\r\n"
        + "6fourfourfourxgrgqklnpcsjbsqvhnkjfcjdhdf\r\n" + "65fpnfszb3\r\n"
        + "srnhthmpseven1four3rrpznf\r\n" + "vgmqr9zttpdrzjfiveninesevendfive\r\n"
        + "fournthreesevenseven72seven\r\n" + "9594\r\n"
        + "twolhvpfzbfsfourrrcpzzshd66grxddrmkvthree\r\n" + "seven5twotwolpsqlbcqpthree\r\n"
        + "29eightzjgsfmll\r\n" + "gtkrjrsevenfbjcpjlsmqsfceightseven9\r\n"
        + "qkbntcjvfl6three9qhpcptvpkfour7b\r\n" + "gvkhmrljmhrpj956bzxhkljpvpxltctjvvpfjtsnb\r\n"
        + "rcqlnpcmng6l5vfkpddeightsevenfhmxzztndq\r\n" + "sptdrlsfxpsxff4five\r\n"
        + "lrzhhxdrkdtbdjbsfourthreemmjjnn1\r\n" + "9sxthreethree\r\n" + "six9fourseven4\r\n"
        + "dpone9fshbbpcm8\r\n" + "twoczqzvqkcnine6eight\r\n" + "qbtkgxp1fourdz\r\n"
        + "dxrrsdbmtpnl6hfdtj\r\n" + "sixsvtwo8\r\n" + "5fxdkhbgqm8fouronefive5\r\n"
        + "jqj6lhtbjt\r\n" + "6pdgrsdxghfkhptbjcrrjcsevenbksvmzvnninercz\r\n"
        + "8rzqvh6ntlg2bfktcphztdkckjg7two\r\n" + "fivesixnine1\r\n"
        + "4beightsevenonetwothree8jx\r\n" + "sixfourmvpk6fourtgknrjmxfftnmngjnine9\r\n"
        + "68seventwosnqsj\r\n" + "g853seven7\r\n" + "7ninejqslxmkxpbkxksjcjlnttslpcmsprvgnrxg\r\n"
        + "jmvqrhdcctwofivev6eightone\r\n" + "ninefiveseven9eighthbb7two\r\n"
        + "threethreethreerlgqzvsevenx3eight\r\n" + "xbkvgdsrhknine3blt\r\n"
        + "xzbcgjkkbk1two1zprpn3bcxxhlxjtx7eight\r\n" + "3tflfncljtwo9\r\n" + "four3seven8one6\r\n"
        + "six7vqfive\r\n" + "ddhhgvrkzfhone8\r\n" + "fqtbnbvdvbklnkmpr89twotwo4\r\n"
        + "9two166eight4cfnsstwo\r\n" + "twofive88\r\n"
        + "nxpmbfiveeightqmtblmtzpjcnxnxjtwosixtwo9\r\n"
        + "fourthreefivedone9jzhrbrzmdqkzmqzfklxq\r\n" + "qbgpfsvlx1eightjsevensixfour\r\n"
        + "2sevenfqkeight2five\r\n" + "sqnsvsevenrbkhgkbhmmqjztzvn3sevennkcghqqcckp\r\n"
        + "eighthcrzxpjt1eightone\r\n" + "sixone2\r\n" + "four56zqxr1lcmblzgdgqjnqb\r\n"
        + "q6hdldzmjh6ninevjm9\r\n" + "j82onek67\r\n" + "5njnffiveshlbqpqhzt\r\n"
        + "97nineoneightcq\r\n" + "ffivetwo41vnzhfqmrd4\r\n" + "two2fiveone1nftfhvzkpltvn4three\r\n"
        + "twofivethree7jlsjxgjfbvnlxhb\r\n" + "rmb4fourlmzgvfcsgn2five\r\n"
        + "6dthkxkcdbssixdlrb38\r\n" + "qgbnpdpchmnnftqpeight9xlmlskqhc156drhpf\r\n"
        + "sevensixsevenjqckcmg6sixxtgvrvm2sgtvrjrq\r\n"
        + "4nnhmghrqrkcmfmqxtqxncljskfvmhfmgqfour\r\n" + "dlpqjk2fivesix7\r\n"
        + "onegtddk5vzgpndqp2five\r\n" + "qsslgone4onelbnbckznrfnjmsgz\r\n"
        + "pvqdbhjgqrgbqkzgpdbmvninekhvfrmpchhxm2\r\n"
        + "tpxvskgzgnnvmnfncvqxxtkmm75vfgmxr4zbpdmdseven\r\n" + "ssnqndqxsevenxztmfq64\r\n"
        + "mcxmhtnbczdfnstjn31six\r\n" + "twosixfz5jvbxxlhdklbp1\r\n" + "five4six952\r\n"
        + "vmnhjm3rzgglnmzj318\r\n" + "dcnprh12qnmmqnvhkrhtrnxs5\r\n" + "5b\r\n"
        + "mkfgxmvsixeight5\r\n" + "crzdkbjthreeone287fourpgzqldn\r\n" + "2cgdd\r\n"
        + "seven8oneeightllqtfbdtmdnvlcsfh5\r\n" + "4seven1zqponeeightlplm\r\n"
        + "c7sevendvmxlfpnr6\r\n" + "eightlkhjgqj6\r\n" + "njvmgjdmx2\r\n" + "9six7\r\n"
        + "3cfbjptcp5one8four\r\n" + "eight6kxc8one\r\n" + "6sevenlpbdcgbhxsixfourseven7\r\n"
        + "4sixeightsix9hq\r\n" + "6eightb\r\n" + "8eight86jkrdgmxdfourthree\r\n"
        + "4dxczptzbvjfive56eight\r\n" + "seven3threerpqhsqspsdpvxj2sevensndcxn\r\n"
        + "zqcbcseventwo4gh16jksxkphgf\r\n" + "44tfour7br\r\n" + "five266five93seven1\r\n"
        + "prsbtlbninendbpzv5xx5\r\n" + "6three2nqgtrlkfxn\r\n" + "ninefourxkrsgshmdd78six7nine\r\n"
        + "gnkphdvhqk74fptcqgp\r\n" + "cfdmp2\r\n" + "fzhhdclzncxmg26nineeight4\r\n"
        + "seventworlcqhfq2qrfiveqqgmmzdpntfm\r\n" + "onedvsbvstdshtlzs6sixfive\r\n"
        + "qjfbtdtcknthreeeightsix71\r\n" + "2ninesixscdxtwo\r\n"
        + "threerlpjxlzsr9qqzmfbzdtnknn2four\r\n" + "8kxxljngrqsgkxcnlhrlxxfgl57fql7\r\n"
        + "vhrjlgqjnnthree4four8fivebfourffcnbghnz\r\n" + "5jb5oneoneonebseven\r\n"
        + "kbkv3three4rgdkdzkrkk\r\n" + "eightxhxzkbhjxsvfsjfbzghktvlqhseven2xkslcrfsgdc\r\n"
        + "sevenone6rmkcvfour6jhvhz\r\n" + "threenhfprcngzhcqckchphcninecmqvczqt5\r\n"
        + "foureight6\r\n" + "7fkrgmdrxgdkfpvxkns9\r\n" + "5onetwoqnp\r\n"
        + "nine73dbfljgnninecdgxrgkdlsqzflbtwo\r\n" + "five3jcsevenfour8sevenjgfxkfgnlzbkb\r\n"
        + "lqtvkrfour67gdnrhkfvzgfoureightone\r\n" + "kct1pljt8seven\r\n" + "six269two\r\n"
        + "64k\r\n" + "41ggbblvhs726\r\n" + "mbvfq5gghsxtwomngfczfdpb1seven\r\n"
        + "4ggzmdpbkrczhmmrk5\r\n" + "317\r\n" + "pxtgbfnfhqgncrsgtf7sixfour\r\n"
        + "dvqnfourcsnmcxnxq7ghmjbgmct\r\n" + "vnskfrdcjdoneddjpkcj7fourjjlllonepxlpjkzbzfour\r\n"
        + "hbdjzfbvrthreekxmlkm49\r\n" + "trptone5bpsxgl\r\n" + "5one1\r\n"
        + "sixsixfzgbninecxssl9\r\n" + "six7xdnsdgsix4\r\n" + "fivefive84fxrzgk4eight81\r\n"
        + "zszvqhms8sstxvfz\r\n" + "3one3sixbmxbfsdbdtmh\r\n" + "qnfgnjgcv6two57\r\n"
        + "5676xzlbzk485seven\r\n" + "five8dbbtpxctf\r\n" + "two1gntvjr\r\n" + "77one\r\n"
        + "vlnkqvczts5tkghpvthree6krgszgx4\r\n" + "nine2threefoureight\r\n"
        + "foursevenhc3twofour\r\n" + "9zzgqfzmfpsfn\r\n" + "ghb57sixeightwofqc\r\n"
        + "6twovninejckdhmcsxkfoursix5\r\n" + "oneqxljxjhnineppln419\r\n"
        + "one2zlfsxrkfourthreexl7\r\n" + "nqbtczpblq856one6\r\n" + "3cxmmzlh1\r\n"
        + "frjsdskzk79lcxvjqqdnlqsmbpbdxrxthreeseven\r\n" + "twoone457fivetbq4\r\n"
        + "fourtvbdksxsjxzgdk77\r\n" + "fourgbvdlpbgztwoftmkjkkmthreesix1\r\n"
        + "nhrqfbzggrskfgmnbg7sevenfzrnlxfbtc\r\n" + "foursevenmdrnfqsn4jvnrntwo29\r\n"
        + "fivevzvszgqvqp6627zqnk\r\n" + "15fcvczdlqprxjzhgbxpxs5\r\n" + "9fourfivejsgvnf9five\r\n"
        + "kzlndjrn8rgq\r\n" + "spfqqx3sevenoneldqnqbmspvsixfiveninezmvks\r\n" + "oneseven5\r\n"
        + "2eightfour5bqbmsnhmtfivebss\r\n" + "ninejnckkvseven4\r\n"
        + "jzhfcmvb8fiveqgq18fivevlpgdnkbq\r\n" + "67four\r\n" + "grzpdtl9\r\n"
        + "lzf8fivedr2fivevbpldcone\r\n" + "nine4bdfptdffgkssltwopl\r\n"
        + "eightlvgfhfbsqrdjrskqkprdlltnzzpfhnczsonetwo5eight\r\n"
        + "7xqfgzglblftvsqqbgpfmthreesix9jfl2\r\n" + "eightgngsvqvrhgmvhtqhbpdeightfour6\r\n"
        + "1bqvpnggbdrfoureightxmclfpfqgjssrpflnzl\r\n" + "eightfive1qvhhthk9ninetwo\r\n"
        + "six36fourfivefivezsvndsl5four\r\n" + "jnpzplgbqf6tlzpsgvzhtnkdvhzhbvhps5\r\n"
        + "cldz3bfpvdxjmc\r\n" + "dpponeseven48sevennineeightrkn\r\n" + "five3fournine\r\n"
        + "2xcckljnjz98mjjscfjsxsevenqhxrqvqmbvhzgkc\r\n" + "sixtwo66469\r\n" + "79four5eight\r\n"
        + "jxqktt47\r\n" + "eight36\r\n" + "rsjlmlj5oneightc\r\n"
        + "xczzpjknphtspmh7eightvfzjjk2five\r\n" + "kmznfcxhsn8fivethreexnineone2\r\n"
        + "four6six\r\n" + "2hhnine627\r\n" + "eightnine1vkdpgvxgm\r\n" + "8three6pvtqmfdxdkxps\r\n"
        + "7frnthree\r\n" + "78tworhldxeighttphp\r\n"
        + "dcmv6vvfbzjdtphbpssjnnqdmrgzgkfdveightwov\r\n" + "zsbmctdseven1snxmqxzgsix9\r\n"
        + "lxtwo4sevenxsix\r\n" + "tkdkqfpj5eightq8two447\r\n" + "seven1onesixfivest\r\n"
        + "45six5sevenseven\r\n" + "jpxxdjphzskpbrllninexmmmdxrznzthreecvsmjssmfxczhm5\r\n"
        + "4flhfqlphfcnn9sevenx3\r\n" + "16ttrmgqninefsgvkt5four\r\n" + "3snfkm\r\n"
        + "6threetwoglgkbqjlsn4fivehcgfour\r\n" + "ninesixfive1ninelgdmhkqrvn\r\n"
        + "two3pxvlsheight\r\n" + "two51\r\n" + "sixninezkbfbxgzznlgtpxgcpzvgkczdbfive8three\r\n"
        + "fourjljzqgbsthreeqjdgsqpspnsixxnglmkss5m\r\n" + "32sevenctqtqrqlsfourfoursixrcjztxx\r\n"
        + "8qlccjngpt\r\n" + "2eight58five\r\n" + "1ninesevenxtlbrq6\r\n"
        + "9fivevkmm8tgxfkzvgq\r\n" + "53txg\r\n" + "3xqmjvxkcbjf2\r\n" + "2fhndgqnqd5\r\n"
        + "2vnrpjdb6four79\r\n" + "7four5\r\n" + "foursix5hdcg489ninerncnk\r\n" + "6s2jd\r\n"
        + "fournine8ninejn6rkknh5\r\n" + "fcfxflzv7seven7\r\n"
        + "1fournineqzknrvfhdxfoureight4seveneightwobr\r\n" + "1two3\r\n" + "twombl5\r\n"
        + "fourzjh9six\r\n" + "1ljrvbrqpcchb\r\n" + "11rvqfmcxgg\r\n" + "fiveoneggjpmdt2t\r\n"
        + "nnjdzhdrkvhpxnprlfrhxpbtpbdxm1xfshdr\r\n" + "five39threehhrhsrhhqkjt9\r\n"
        + "hm8nine\r\n" + "3ldckgksm48xc2seven8gbzfq\r\n" + "sixqpcqjzqxsjhr7\r\n"
        + "kthreethreelmjfour485\r\n" + "mnggrsbbnh1\r\n" + "xfn5\r\n"
        + "qzlxtczqlvninekjnbnonefcbqqgfmqf66xpvjgfzjgxvjrcqmzx\r\n"
        + "krsfvctzfhonejxtqbbnd7eight\r\n" + "tjhgbtqtwoljone9\r\n"
        + "mdfntzfpg1fiveninecvxrfnine2\r\n" + "7hcrxzc\r\n" + "6two6plgrmbnine9sdbvgtnj\r\n"
        + "threenine4fthstfjzzp\r\n" + "6eighteight9npghczggthreectqssdtp\r\n"
        + "flc4gtqsjmrddx8eightseven\r\n" + "threeone1oneone7\r\n" + "gfbfjzltcjfkkrsprgtpfive4\r\n"
        + "sixrdzp2onesevenrqrtldnq4c\r\n" + "sevenktwo3threeeightthreenhnmpdmlqjnvl\r\n"
        + "4eight82717\r\n" + "nrhqqkmkeightthreenzqbgcphoneseven7\r\n"
        + "twoprrgggznzffour5bbrdsvtgkkrbl5nlrkpjmnbzgsbtl\r\n" + "28pvjrszmrdntp4nqdnhkdrtwoxr\r\n"
        + "sixsix9five4\r\n" + "lxchg91threethree74\r\n"
        + "6bmxblxdkghqdjqgqbrqtxknvdsevenztgspsfh83\r\n" + "39bsspvhslzkmrnzxtlxsbhk4\r\n"
        + "74seveneight9ninedgzgjdvxgvrnfz\r\n" + "fourxvvqsfktptjbsb69\r\n" + "rxsevenfive5vx9\r\n"
        + "72six7\r\n" + "five5lcxv2jvsssxqjtmzclfdfourfive\r\n" + "87three9\r\n"
        + "6rckksfour413331\r\n" + "33gtz\r\n" + "xkmxtvzhgxqqmknn9pzhgjxqseight\r\n"
        + "8threefivedrtlgrnqfouroneq\r\n" + "6snzkxjcfive62dqtqmtwoxnine\r\n"
        + "zxtjclonefour1eight5eight1\r\n" + "qlffthreeseven2three\r\n"
        + "xfppngbg5six3two8nine\r\n" + "ninesevensevencfhppvhdnfour8\r\n" + "xhvnm1\r\n"
        + "9threecbdccktrkfourfour9twoneqd\r\n" + "1five4fivenine\r\n" + "jcscpdtzk757nine8\r\n"
        + "sevenninesixxkzzzbfour2three\r\n" + "sixthreetwovfqxtbvcrrjtwo3four9\r\n"
        + "nzdjhtlqfnxmrzvgrzkfmm7mhmvbbxfd\r\n" + "3seven2eight99\r\n"
        + "two6nineljvxs5eightseven3\r\n" + "55fivezgbmcdpv\r\n" + "hkgvvrtrtwopjbqhtts8seven\r\n"
        + "c138\r\n" + "mnrnhqtzthreesnnj2\r\n" + "81\r\n" + "qscxbblvsxsgtcpr4cphmxgmbrb\r\n"
        + "4six2mrvdpxqvhngrrzhjdjfp\r\n" + "4tmrlmdfivefivethree7\r\n" + "363\r\n" + "8488one\r\n"
        + "827pcxnhpk\r\n" + "ckbdqdvhdd4hrb9nnghltwo\r\n" + "5onecjjfdfrxppqkhrpthree5lr4\r\n"
        + "62lvlsp2sixfive5\r\n" + "czxfkhcbvcdhdzx2\r\n" + "jzdgngb68\r\n"
        + "fourtwo18pxkttcr8four\r\n" + "bkttjvvmxvzkhmxtpqrxxhslstwo6five22\r\n"
        + "four26mcvb2fivepone\r\n" + "dzptwo5ninejgjrfour\r\n" + "nrhqqnjfour9four\r\n"
        + "ffoneightpxp41six\r\n" + "threeninehzmrh8dzvmpgrhsv\r\n" + "5onefour5\r\n"
        + "jdl5fourtwo8\r\n" + "threefour8seventwo1seven\r\n" + "lvkjd6five6fxkfthxkgmfour6\r\n"
        + "three3seventhreepbsgc\r\n" + "7threethree6fgmfgcv6glrk\r\n" + "nine3five\r\n"
        + "54one9\r\n" + "jhvqhrvqfrfgpdrh3three5\r\n" + "3psztbfour4\r\n"
        + "nlffive1nxcqpfour232\r\n" + "3threetwosgsbdjnt\r\n" + "dtfstb1qhggj\r\n"
        + "qnnp9twojdg4kfzvtbsevenfour\r\n" + "qfnmdkfkpndd36sixsixfourseven\r\n"
        + "8seven7oneseven9x4five\r\n" + "4847onetgmsbjjqhtfiveksmmlftk\r\n"
        + "fivesixlklrnhtdfg3\r\n" + "cpcqone1pnxkhrkdhhzheightlpb5three\r\n" + "eighttwo6\r\n"
        + "seven2fourfourvfzxqbh7\r\n" + "frf1fivesix3snnlpgpc7\r\n"
        + "svtvfcsevenhszznbzpfiveeight2\r\n" + "lqpqzthree5mcmzpqlxkgpssix\r\n"
        + "9sltfzqsczpjbndmqbccgmq\r\n" + "5six9fourxppzkgbj6\r\n" + "8dqhklnxseven1\r\n"
        + "3two4\r\n" + "ktvlhmq3xzmcztbplxlqzpqmoneightffd\r\n" + "76dklx7two8nine5vgvh\r\n"
        + "xmgjgfz4\r\n" + "two7tcnceight9\r\n" + "ninecvfgpbrqcgvplt32six\r\n"
        + "g3rcbzqxnjllqoneklpbjzbqbseven\r\n" + "svkf8ggdnmeighthhjlz3four\r\n"
        + "hfdb44zqjmxbrft3qrpgvjngc1\r\n" + "dzsbnsrg35tm\r\n" + "qchpdcg2\r\n" + "9775fcg91\r\n"
        + "gdrhdgmfdk77eight\r\n" + "14bsixthreeseven\r\n" + "two1twoninepkkvhlzlt3\r\n"
        + "kvslhphhj9fourvljqbfive\r\n" + "8nc6\r\n" + "qg7six\r\n" + "7vkgv8\r\n"
        + "td5fivefive\r\n" + "xvfour8jttrsvvjkkdxxzjsl\r\n" + "7qbgdfkj4fourfivenmqtfmgeight\r\n"
        + "eightfourdzxpfggzxcqrmtxnggchlqtwokcnrdhqf1\r\n" + "lbhcptlfhflgthreefive9cpprdlbv\r\n"
        + "nine7941cfxnxszfivebm\r\n" + "ninenhgpj7fourfour9\r\n" + "456xg\r\n"
        + "ninethreesqdp11four32lgdl\r\n" + "38trrgt7\r\n" + "tnhhxlm3rvzvxmmcgpxm\r\n"
        + "oneqtmg25snbgzfhtkq8hdlvszrclcsrhqsdn\r\n" + "3cjndzmkfx\r\n" + "clxvdv7seven\r\n"
        + "five6three1\r\n" + "8sixfour36seven9mlxmrx7\r\n"
        + "vdrk27jnrbrvdrnine2nvnlkcszoneightchk\r\n" + "67drgjqrqdktplq\r\n"
        + "36pprvngxrrjtnpffmrxxdl\r\n" + "hkkrgxtpvzzmcrfcbcjzbpnvls88hrxl\r\n"
        + "b4jkeightsevenmxkdpvdpt857\r\n" + "6eighteight2four\r\n" + "eights73five\r\n"
        + "fiveslpjvzjlpvzone41nine\r\n" + "smnmlrxx7\r\n" + "onesixfive4\r\n" + "8s75eightone\r\n"
        + "1fivecpqsxm\r\n" + "99743ninesix\r\n" + "twopzflcvxsgzn1v8\r\n" + "9three49\r\n"
        + "two2sevenf8sixvdpxzgxbmkrz2\r\n" + "sevenfive6shhbqhgqqhstdrnfxsjtjvnine\r\n"
        + "kzqsvn29s\r\n" + "threenlrrhz4ttqljvr\r\n" + "qx9sfdx\r\n" + "nhsbgsvvp7\r\n"
        + "876eightfivetprjjbxhzbfpqgltt1\r\n" + "six3xdjtphrm1pbjvjfn\r\n"
        + "nflcpmjpt6six9two6xvbmbm\r\n" + "fmlglbgmhvseven4nnkkgcmbv9chmthxvztgsevenbtzs\r\n"
        + "7bkmchf4five\r\n" + "xgglktnbeight183twonine\r\n" + "onecbpdv9\r\n"
        + "fhhmddrnlnkvlb5drtcbrjprzcqlj7mgspc\r\n" + "7threexkfjklvzcfourtnrgmpveightfour8\r\n"
        + "6rhmcblhfourtwo3two\r\n" + "one4fiveonenine\r\n" + "slksfchvlgblninefszfbksddgvd4\r\n"
        + "four742sbseven3lk\r\n" + "8qbchrfldtvppv6fourzfivez\r\n" + "ninephsmnnvsfour1\r\n"
        + "one5kvcrtnc5sixonehjfxnsixfqhzjj\r\n" + "8drgrzngh\r\n" + "16eight8rczbjmblhn\r\n"
        + "threejpgjbpfdbvgdpftwo96\r\n" + "sfkhvjgd2smgfkr9two27\r\n" + "threeqpdeight3\r\n"
        + "threesevenxblrmqkvzvrbhsix4\r\n" + "9seven2vlhsninenvptdvmrpzbrlpfhfnl\r\n"
        + "xkjpdpgsrtvlfg1eight\r\n" + "seven254\r\n" + "three8fnmcfhrdtjdlpfqlqhgx\r\n"
        + "21bkjv54s8\r\n" + "82ddfour6vcggxhlmpfivesix\r\n" + "cdsbgtpqthreefivel8nine\r\n"
        + "5five5cksct7bvjbtdjkcz\r\n" + "64fhm\r\n" + "tqk5\r\n" + "3mhzkhtfzscpgfctfskdn2five\r\n"
        + "cvmvthreez8fivegvcbsxj35nfxdshqz\r\n" + "sevenqlqmkhdjpmsjrtggqzfive35scmnfpmhmp\r\n"
        + "sixfive2\r\n" + "6sevensvqhhfivetwo\r\n" + "eightthree84\r\n" + "82six8\r\n"
        + "8bbhrkzgtg59cpgdvb\r\n" + "11three3hfjkvmsl\r\n" + "qdljkm792\r\n"
        + "eightgq5xgskvtpgmhxsnhzlqhnksxflvx\r\n" + "ghdhv1seventhree55fourthreemrlhq\r\n"
        + "oneonethree3zm\r\n" + "3twobsxqfsfnine\r\n" + "eightsbznkpzsqqtpxfhlfr5\r\n"
        + "sevenchs2twoeight\r\n" + "ninezjtxp7bpzdgtoneeightoneighth\r\n"
        + "fmkbvzzgvl46fiveoneightqn\r\n" + "kvsonevxtmmxnfour4lpxjrbcfoursixp\r\n"
        + "391onelktkfd1three2twonels\r\n" + "pn2\r\n" + "3cmsmfvjchflngkrbtsfrblltwo\r\n"
        + "eightfour8ninesix29\r\n" + "dpdvnonefour2eightbzzrvthmkgfcdv5\r\n"
        + "59sfiverboneone3\r\n" + "6xrqq1\r\n" + "9bczfbfbhkntmdmseven68\r\n" + "npqm35qszmptx\r\n"
        + "fivepkdlmonefivesixz252\r\n" + "dzrtwonetbbv9twovrsp\r\n" + "fpkfourfivendkhz6five\r\n"
        + "86dknvgcnmcslmztwo3\r\n" + "fivetxrrzjpb6tqseightjthnhn\r\n" + "362zhtxdgvcdgnzv55\r\n"
        + "eightsevenbllbgvdonethreeprglpjhxhqfdn6csnghrtl\r\n" + "5fourc\r\n"
        + "8fournine3svdlh5sevenoneighttsq\r\n" + "eightjkqmgljpprcpblvrthreeseven8fourone7\r\n"
        + "vqrqlhmb9seven231vbfzrrstwohjvdjgg\r\n" + "kk1foursixeight849\r\n"
        + "seven13ttbnlr21\r\n" + "jfgsksrrkjsixsixthreesixfourrbxqzdhc9\r\n"
        + "3fiveeightqbndjdg6pmftqshone\r\n" + "nineoneseventkdpztbkk83two4\r\n"
        + "cjdbxhpzr87eight\r\n" + "twosevenkkdhf86sevendzhvkrttjljr\r\n"
        + "67cdltmnbkktzseightsix7two\r\n" + "three44zqtglqcffrkmhsgjfive\r\n"
        + "twoonenbf74three9tthsvmngcx\r\n" + "lvrnpvmvgvnnonesix5\r\n"
        + "nchcfxxphmnqbhfourxnine52sixj\r\n" + "fourqpvngjszftg88seven\r\n"
        + "xgzmv133zvjmlfqhcmjbqzfntkjtpdjlkmv\r\n" + "fivejxc4threebzqbhrldsf\r\n"
        + "glvtpvnsevenqvrtcgjkhkcsix1seven\r\n" + "sjeightwo4fivesevensixnqxsjckfive\r\n"
        + "z5\r\n" + "jxxhsmdvkglljhxzxljqz9zplmslcfdxxljtwosixkjxlsrfcx\r\n"
        + "fiversdslrkcqclzb7zdzlbllfkvphfqhnfour\r\n" + "five1hpdncfpzhdxrhnv4lblgthree7snj\r\n"
        + "8scqf\r\n" + "threepcfkrhstmsbfvqxsxrctwo185six\r\n" + "7lqvpqxbjrv9nine985\r\n"
        + "eight16jvfqcgbmhdgdltxz9\r\n" + "three8vncqf9\r\n"
        + "zrzp9sevenxthpsxtdninebmnhgrkdjqqjfffourblbkch\r\n" + "fiveseven25snpsnjgnfl\r\n"
        + "ninefourxrtdlb1threefivefive1rbqzfbxtst\r\n" + "three8three7five41\r\n"
        + "tcnvsevenz45fngtjljh\r\n" + "txvpst1\r\n"
        + "eighthrlbmtk4nssknqmxjvjnqsqlfivekzrphrtwo\r\n" + "two492ninekcjvllckdtkp\r\n"
        + "48vlvmkcvbsfoursix8\r\n" + "eight28sixsix3nine45\r\n"
        + "jkm8hhqfclneightjlpsnck8dcvlvgkrfprflsvlh\r\n" + "4zxjqlfn\r\n"
        + "fivebpqfjtcmlsixfour48onejqhzgtftrvkknngf\r\n" + "dkfour7fivezzsjdbnvgninefivenine5\r\n"
        + "twoxjqldtk91eightneight\r\n" + "seven57177\r\n" + "gpbqvlpxvnzgninefoureightthree5\r\n"
        + "bzprbrninesnjpgqthreeeightsixtgmvrthfour4\r\n" + "83brtxx4zzxsxrcfivebzbxlsl\r\n"
        + "threesevenninetwo8twoone\r\n"
        + "veightwochrmfrkrcppxkj4tvvzmhqjhnjvtq1threegtmfnnjpxb\r\n"
        + "3zgqpvq9krslgjgkjmtbsbhbjg\r\n" + "4nine8mhfs67vhdjvsjrlz2\r\n"
        + "nine659xrvhhnnbqq7\r\n" + "bninetwoeight8fxntpdkrfp9eightnb\r\n"
        + "qtwonecvbgxqfiveoneeight4five\r\n" + "seven926\r\n" + "shkkksn4onefivethree\r\n"
        + "eightsevenqvfqmzqsfn1\r\n" + "sixdgjmtk5fivevqbxxdzrjqdtgnnffzmfqxzjdzhp\r\n"
        + "stsjcmzbxt1\r\n" + "rvnone3three9twozchp26\r\n" + "ninefmpkdlvzfivetwo1\r\n"
        + "four4one4vdpgp9lprtqjzmhk\r\n" + "15rpdhczznrzclfcsxdx41\r\n"
        + "seven36twopnvjdxrss5\r\n" + "46ninenine\r\n" + "6jg8xtqfmjffdlfhzrn\r\n"
        + "2jsixfive573\r\n" + "two8eight39fbqkdzseven9\r\n" + "3gnrg5\r\n" + "hlkk1\r\n"
        + "1sevenfive7\r\n" + "72jvdqmlrddk\r\n" + "ninetwo8hzdninesixnjhgrcsttwo\r\n"
        + "23cxdccvvjrjfsixlcrmxjkeight\r\n" + "6brqjfjsix56nine3\r\n" + "ninezveighttwogc5two\r\n"
        + "ninexskpsth5sevennine\r\n" + "c7jmmjcv\r\n" + "89sixthreeeight71q\r\n"
        + "fivekccfngmxseven7onernfskqnqfive5\r\n" + "sevensixone4hfhgs\r\n"
        + "xq2jxddpdm3nine8ptqlm4\r\n" + "smsevendj19fbqdjpznfourgqq6\r\n" + "7147\r\n"
        + "znqbfmcpd4twoseven\r\n" + "fhcsmxtdx6\r\n" + "sxj2tcb92\r\n" + "6nine6\r\n"
        + "qdfknmdzt88\r\n" + "66threebsndqlkrshfive5\r\n" + "eight7pckdhlqzrx24\r\n"
        + "3ninevk\r\n" + "sevennine3\r\n" + "8one1rjtnhjx\r\n"
        + "eightthree3ninekzhtlqsevenssprmrqhhgncrs\r\n" + "6one8nlzxfxvr\r\n"
        + "4cgm9fivethree\r\n" + "four77gxvdqztzzgbsxhntwortndzqzj\r\n" + "t8three335\r\n"
        + "c2rjggzl\r\n" + "jjgjbqgbnz4gdsqk66991\r\n" + "ninezckbpsr9\r\n" + "jb5sevenseven\r\n"
        + "one5nfdcvx\r\n" + "1kbcmclhrh1onejzft\r\n" + "fiveninefivedglztnjxblonehfive3\r\n"
        + "6onesixh6onethree9\r\n" + "spdzhnt5tpzrkh1fxlnine4skgzdln\r\n"
        + "1onenineqgzcq2eightwonh\r\n" + "vfzvds826vtlrcg6rvseven\r\n" + "vqmoneight9tknqtcsmb\r\n"
        + "kqrcrqrqjbdeight7ckhr23\r\n" + "oneeight2\r\n" + "8eightnhtqcggtxc6dfsfcjfpznmsthree\r\n"
        + "sxfvfdkff8dvlmbdktsixmzpnxzmml2\r\n" + "9lgmxktj1frxl";


    int sum = 0;

    String[] lines = values.split("\r\n");

    for (String line : lines) {
      sum += toTrebuchetVal(line);
      System.out.println(toTrebuchetVal(line));
    }
    System.out.println(sum);

  }
}
