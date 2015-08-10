
public final class Codon {
	
	/**
     * @param initacids initial list of acids inputted by user
	 * @param length length of base pair String
	 * @param bases String of base pairs inputted by user
	 * @param frame specifies which character the user wants to begin transposition from
	 */
	
	private final String[] initacids;
	private final int length;
	private String bases;
	private final int frame;
	
	public Codon(int strlength, String base, int firstframe) {
		length = strlength;
		bases = base;
		frame = firstframe - 1;
		initacids = new String[(length - frame) / 3];
		reduce();
	}
	
	public void reduce() {
        // if section of acids to be analyzed isn't divisible by 3, the ends are cut off
        
        int tryer = (length - frame) % 3;
		
		if (tryer % 3 == 1) {
			bases = bases.substring(frame, length - 1);
		} else if (tryer % 3 == 2) {
			bases = bases.substring(frame, length - 2);
		} else {
			bases = bases.substring(frame, length);
		}
	}
	
	public void read() {
		
		int j = 0, k = 0, best = bases.length();
		
		for (int i = 0; i < (best / 3); i++) {
			String value = bases.substring(k, k + 3);
			
			switch (value) {
				case "TTT": case "TTC":
					initacids[j] = "Ph";
					break;
				case "TTA": case "TTG": case "CTT": case "CTC": case "CTA": case "CTG":
					initacids[j] = "Leu";
					break;
				case "ATT": case "ATC": case "ATA":
					initacids[j] = "Iso";
					break;
				case "ATG":
					initacids[j] = "Meth";
					break;
				case "GTT": case "GTC": case "GTA": case "GTG":
					initacids[j] = "Val";
					break;
				case "TCT": case "TCC": case "TCA": case "TCG":
					initacids[j] = "Ser";
					break;
				case "CCT": case "CCC": case "CCA": case "CCG":
					initacids[j] = "Pro";
					break;
				case "ACT": case "ACC": case "ACA": case "ACG":
					initacids[j] = "Thr";
					break;
				case "GCT": case "GCC": case "GCA": case "GCG":
					initacids[j] = "Ala";
					break;
				case "TAT": case "TAC":
					initacids[j] = "Try";
					break;
				case "TAA": case "TAG": case "TGA":
					initacids[j] = "STOP";
					break;
				case "CAT": case "CAC":
					initacids[j]= "His";
					break;
				case "CAA": case "CAG":
					initacids[j] = "Glu";
					break;
				case "AAT": case "AAC": case "GAT": case "GAC":
					initacids[j] = "Asp";
					break;
				case "AAA": case "AAG":
					initacids[j] = "Lys";
					break;
				case "GAA": case "GAG":
					initacids[j] = "Glu";
					break;
				case "TGT": case "TGC":
					initacids[j] = "Cys";
					break;
				case "TGG":
					initacids[j] = "Tryp";
					break;
				case "CGT": case "CGC": case "CGA": case "CGG": case "AGA": case "AGG":
					initacids[j] = "Arg";
					break;
				case "AGT": case "AGC":
					initacids[j] = "Ser";
					break;
				case "GGT": case "GGC": case "GGA": case "GGG" /* ayyyyyyyy lmao */ :
					initacids[j] = "Gly";
					break;
			}
			j++;
			k += 3;
		}
	}
    
    @Override
	public String toString() {
		String returner = "";
		
		for (int i = 0; i < initacids.length; i++) {
			if (i != initacids.length - 1) {
				returner += (initacids[i] + ", ");
			} else {
				returner += (initacids[i]);
			}
		}
		return returner;
	}
	
	public String[] getAcids() {
		return initacids;
	}
}
