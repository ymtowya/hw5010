import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;

public class BinarySearchTreeTest {
  
  BinarySearchTree<Integer> tree1;

  @Before
  public void setUp() throws Exception {
    tree1 = new BinarySearchTreeImpl<>();
  }

  @Test
  public final void test() {
    tree1.add(7);
    tree1.add(6);
    tree1.add(9);
    tree1.add(2);
    assertTrue(tree1.present(6));
    BinarySearchTree<Integer> tree2 = new BinarySearchTreeImpl<>();
    int[] nums = new int[] {953, -128, -176, 174, -528, -568, 185, 161, 303, 171, -231, -260, 746, -836, 203, 626, -834, -867, -145, -924, -197, -751, -529, 213, 219, 313, 99, 289, -585, -216, 149, 594, 884, -112, 600, -195, -896, 260, 985, 625, -831, -894, -945, 918, -614, 231, -14, 727, 556, -880, -637, 564, 890, 147, -291, -672, -608, -190, 542, -166, -133, -39, -634, -15, -357, -303, -966, 362, -478, 664, -829, -690, 468, 773, 685, -530, 562, 529, -331, 363, -347, 126, -3, -349, -32, -496, 780, 506, 502, 786, 355, -969, 321, -477, 535, 732, -223, -200, 387, 134, -993, -406, -650, -541, 243, 21, 450, -660, 71, -795, -25, -704, -590, 84, -897, -613, 69, 3, 458, 180, -472, -743, 802, -425, 165, -807, 922, 493, 656, -98, -543, -816, -868, -876, -991, 413, -618, -736, -726, -210, -74, -7, 329, -238, 348, -434, 813, 721, -891, 371, 95, 702, 803, 58, -224, -490, 447, -554, 658, -927, -113, 347, -239, -517, 479, -852, -492, -846, 531, -42, -398, -157, 441, 1, -720, -22, 384, 361, 310, 92, 318, 711, 763, 577, -841, -621, -742, -972, 597, 11, 613, 999, 669, -315, -959, 461, -256, 581, -146, 940, 365, 6, 719, 206, -926, -80, -791, 589, 769, -489, 276, 920, -682, 779, 195, 282, 286, -698, -289, 499, -745, -452, -104, -573, -768, -203, -865, 82, 262, -420, -118, 54, -692, 389, -27, -326, 672, 218, -928, -767, -910, 821, -572, 278, 410, 856, -845, 152, -796, -900, -980, 571, -230, 334, 495, -61, 724, -715, 695, 222, -915, -988, -378, -861, 983, -534, 41, 87, -810, -167, 37, 383, -244, -309, 118, -696, 449, 457, 223, -464, 540, -271, 587, -181, 691, -710, -985, -764, -714, 217, -126, -564, -300, -783, -902, -81, 518, 757, -737, 256, 969, -324, -93, -582, 513, -551, -548, 881, 699, 794, 375, 31, -64, -363, -984, 887, 688, -50, -308, 862, 238, -232, -444, -183, -4, -624, -952, -849, -689, -961, 88, -706, -10, -187, 40, -34, 511, -85, 783, -785, 547, -971, -625, 549, -686, 287, 982, 378, 97, 575, 628, -108, 797, 244, 416, 582, -781, -805, -769, 782, 323, 496, -276, -110, -448, -958, 646, -293, -330, -681, -626, -940, -11, -674, 60, -26, 720, -411, -317, -814, 627, -938, -889, 154, -864, -569, 79, 124, -965, 892, -29, -321, -636, 603, 252, -205, -639, -127, 26, -455, -262, 768, 421, 731, -219, 621, 480, -703, 580, 861, 505, -870, 859, 570, 167, -833, 579, 987, 588, 590, -617, -771, 284, -332, 822, -427, -169, -322, -117, -754, 860, 266, -20, -154, -431, 548, 741, -343, -759, -855, -987, 733, -773, 933, 830, 974, 194, -493, -495, 51, 955, 367, -31, 996, 641, 309, 434, 612, 460, -201, 653, 894, 630, 601, 994, -970, -898, -353, 39, -538, -843, -986, 681, -453, 602, 586, 790, 713, -550, -623, -368, -87, -869, 295, -372, 425, 403, -784, 868, 315, -629, 101, 964, -937, 76, -45, -147, -138, -485, -198, 63, 912, -761, -40, -713, 795, 210, -139, 660, -247, -302, 72, -500, 358, 297, -878, -502, -242, -535, 520, -92, -756, 12, -140, -727, -385, 552, 248, -487, -580, -474, -423, 988, -665, -677, -827, -178, 644, -774, -399, 596, 610, -426, -460, 516, -158, 138, 78, 89, -799, 32, 811, 234, -188, -652, -975, -96, -391, -213, 975, -270, -685, 160, 208, -858, -531, 638, 979, 659, -350, -172, -989, -823, 105, -923, 904, -974, -337, -174, -671, -640, 419, -994, 852, 263, -694, -394, 268, -185, -66, 322, -503, 941, -102, -794, 948, -515, -358, 893, -227, -838, 652, -702, 155, -418, 132, -218, 976, -59, -776, 116, -593, 599, -563, 396, -433, 873, -597, -537, 349, -516, 327, 337, -432, 696, 850, 472, -142, 141, 703, -732, -310, -675, -199, 143, 133, 397, -645, 990, 905, 481, -808, 257, 288, 283, 424, -175, 345, 972, 845, -763, -930, -514, 198, 710, 111, 191, -75, -71, -155, -124, -920, -76, 166, -482, 354, -339, 159, -114, -486, -467, 494, -184, -6, -206, -143, 785, 871, -304, 929, 431, 498, 826, 119, -33, 899, -351, -939, 701, 232, -549, -630, -106, -895, 33, 302, 686, -661, 611, 736, -458, 882, -631, 944, 740, 668, 272, -367, 236, -857, -616, -844, 572, 112, 226, 519, 931, 227, 816, -365, -63, 798, 932, -264, 364, 110, 998, -160, 202, 755, 335, -382, 906, 936, 4, -296, -340, -729, 801, -762, -361, 67, -813, -408, 258, 339, -402, -151, -5, 622, -556, 485, 661, 113, 443, -476, -931, 102, 888, 487, 50, -651, 911, -273, 835, 204, 44, -35, -673, -777, 620, 847, 901, -893, 183, -830, 320, 186, -424, 280, 804, 381, -488, 849, -586, 199, -723, -521, -526, 343, 927, 583, 968};
    for (int tmp : nums) {
      tree2.add(tmp);
    }
    System.out.println(tree2.preOrder());
  }
  
  @Test
  public final void testPresent() {
    int[] nums = new int[] {685, -671, -970, 600, -637, -588, -467, -415, -764, 234, -629, 199, -618, -419, -941, -807, 658, -26, 751, -108, 852, -161, -392, -197, -194, 15, -3, -293, -574, -504, -958, -497, -779, 529, -846, -519, 742, 773, 540, -30, -899, 521, 863, 63, -678, -685, -995, 517, -188, 878, 452, 397, 419, -479, 556, -863, 875, -199, 706, -781, 146, -987, -694, 881, -931, 82, -324, 582, -306, 411, -276, -810, 599, -919, -230, 522, -494, -451, 893, -215, 861, -971, 166, 636, 718, -529, 429, 766, 161, 971, -817, -999, 654, 584, -424, 982, -554, 339, -271, -599, -501, -4, -936, -942, 488, -630, 123, -211, 338, 98, 412, 381, 646, 219, 402, -768, -490, -722, -796, -1000, 752, -400, -464, -706, -187, 769, -739, 810, 943, -394, -190, 957, -847, -438, 764, 511, 561, -691, -868, -170, 147, 38, 434, -828, -742, -76, -640, 87, 446, -143, 291, -545, -635, 6, -115, -485, -527, 365, -702, -791, -713, 715, 179, 40, -326, -384, 626, -632, 169, 159, 33, -699, -354, 149, -125, -808, 921, 621, 996, 79, 332, -684, -154, -611, 524, 347, 65, -376, -113, -826, 887, -580, -387, 389, 691, 275, -181, 124, -585, 543, -176, -727, -646, -876, 618, 140, -292, 859, 440, -98, 470, -442, -476, -508, -669, 237, -274, -351, 167, 800, 993, -570, 17, -117, -993, 66, 889, 334, 396, 61, 330, 134, -850, 825, -798, -372, 855, 294, 216, 970, -735, -608, -411, -169, 91, 417, 868, 944, -614, -991, -86, -929, -839, 616, 453, 148, 253, 150, -935, 657, 297, -726, 799, -836, 884, -20, 676, -347, 379, -789, -142, -455, -16, 902, -937, -268, -69, -767, 879, -144, -255, -745, -949, 686, 42, 27, 227, -41, -221, -542, 311, 346, -865, 644, 125, 80, 128, 738, -79, 724, 808, 592, 635, -521, 950, -226, 126, 924, 215, 778, -515, -482, 909, -634, -159, -660, 407, 569, -488, 916, 899, -852, 28, -534, 354, -9, 892, -128, -182, -988, 814, -210, -202, -7, 501, -976, -731, 530, -561, 941, -498, 211, -880, -208, 845, -984, -237, 361, 478, 898, 641, -831, -251, 263, 630, 386, 455, -348, -804, -434, -916, 367, -628, 628, 162, -452, 507, -710, -225, -247, -709, -222, -402, -956, -242, -524, 436, 498, -787, -96, 313, -374, -647, -829, 163, 750, -192, -903, -195, -50, 888, -553, -495, 951, -123, -233, 698, -960, 997, -356, 21, 232, -869, 978, 891, -92, 19, -749, -962, 832, -236, 558, 882, 54, -856, -333, -785, 189, 614, 94, -518, 872, -533, -106, 822, 835, 954, -811, -945, -546, 714, -638, -24, 505, -93, 318, 121, 573, -391, -878, -458, 99, 740, 84, 390, 255, 743, -136, -432, -825, -536, 844, 726, -905, 231, -88, -148, -422, 809, 59, 109, 516, 935, 138, 471, 376, 464, 827, 688, 858, -842, -780, -801, -416, 988, 793, -679, -737, 607, -773, 88, -921, 39, -177, -153, 760, 601, 105, -530, 325, -549, 771, 373, 176, -953, 424, -974, -711, -885, -426, -252, -67, 490, -718, 242, 728, -417, -535, 474, -175, 937, 246, -968, 638, 9, -704, 500, 112, 443, 798, 783, -54, -28, 873, -715, 218, 716, 239, -310, -870, 421, 874, -107, 168, -6, 256, -719, -298, 102, -14, -594, 323, 113, 734, -762, -55, -750, -396, -201, -377, -736, -537, -403, 461, -48, 74, -462, -362, -996, 400, 551, -132, -278, -453, 952, 186, 509, 392, -758, 410, -97, 797, -793, -101, -526, -864, 777, 119, -248, 682, -15, 886, 454, -273, -5, 538, -981, -741, -612, -56, -196, -667, -516, -616, -249, -409, 577, 2, 805, -975, 393, -849, 473, -152, -766, 251, 276, 142, 806, -964, -465, -712, 560, -80, 292, 536, 767, -506, 204, 494, 850, -892, 296, -72, 723, 697, -317, -449, 617, 34, 160, 207, -619, -969, 178, -866, 97, -539, 155, -883, 345, -575, 922, 388, 139, 377, 707, 502, 736, 362, 566, 328, -507, 816, -75, 700, 370, 450, -17, -66, -328, -71, 548, 22, -184, 721, 404, -675, 305, 571, 114, 871, 779, 817, 673, -538, -913, -674, 382, -723, 281, -174, -686, -412, 316, 519, 25, -129, 506, -576, -124, -776, 631, 486, 444, 877, -502, 448, 756, 856, -336, -822, 67, -149, 11, 594, 650, -755, 462, 926, 465, 664, -592, 789, -338, 984, -600, 184, -648, 57, -46, 980, -751, 304, -130, 606, -496, 966, 712, 336, 934, -365, -523, 289, -398, 314, 518, -371, -267, 713, -346, 931, 4, -559, -816, -166, -359, -928, 36, 565, 695, 904, -110, 683, 659, 268, -598, -363, 463, 972, -760, 967, -682, -378, 853, 942, 243, -399, 838, -339, -652, 272, 745, 492, -73, 854, -100, -207, -886, 535, 890, 975};
    for (int tmp : nums) {
      tree1.add(tmp);
    }
    assertFalse(tree1.present(-998));
  }

}