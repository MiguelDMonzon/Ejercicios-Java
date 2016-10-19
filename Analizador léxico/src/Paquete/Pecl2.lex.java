import java_cup.runtime.Symbol;


class UpdComp implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	UpdComp (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	UpdComp (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private UpdComp () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int OUT = 4;
	private final int IN = 3;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int OPCODE = 2;
	private final int BEHAV = 5;
	private final int yy_state_dtrans[] = {
		0,
		219,
		227,
		235,
		240,
		245
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NOT_ACCEPT,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NOT_ACCEPT,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NOT_ACCEPT,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NOT_ACCEPT,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NOT_ACCEPT,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NOT_ACCEPT,
		/* 89 */ YY_NOT_ACCEPT,
		/* 90 */ YY_NOT_ACCEPT,
		/* 91 */ YY_NOT_ACCEPT,
		/* 92 */ YY_NOT_ACCEPT,
		/* 93 */ YY_NOT_ACCEPT,
		/* 94 */ YY_NOT_ACCEPT,
		/* 95 */ YY_NOT_ACCEPT,
		/* 96 */ YY_NOT_ACCEPT,
		/* 97 */ YY_NOT_ACCEPT,
		/* 98 */ YY_NOT_ACCEPT,
		/* 99 */ YY_NOT_ACCEPT,
		/* 100 */ YY_NOT_ACCEPT,
		/* 101 */ YY_NOT_ACCEPT,
		/* 102 */ YY_NOT_ACCEPT,
		/* 103 */ YY_NOT_ACCEPT,
		/* 104 */ YY_NOT_ACCEPT,
		/* 105 */ YY_NOT_ACCEPT,
		/* 106 */ YY_NOT_ACCEPT,
		/* 107 */ YY_NOT_ACCEPT,
		/* 108 */ YY_NOT_ACCEPT,
		/* 109 */ YY_NOT_ACCEPT,
		/* 110 */ YY_NOT_ACCEPT,
		/* 111 */ YY_NOT_ACCEPT,
		/* 112 */ YY_NOT_ACCEPT,
		/* 113 */ YY_NOT_ACCEPT,
		/* 114 */ YY_NOT_ACCEPT,
		/* 115 */ YY_NOT_ACCEPT,
		/* 116 */ YY_NOT_ACCEPT,
		/* 117 */ YY_NOT_ACCEPT,
		/* 118 */ YY_NOT_ACCEPT,
		/* 119 */ YY_NOT_ACCEPT,
		/* 120 */ YY_NOT_ACCEPT,
		/* 121 */ YY_NOT_ACCEPT,
		/* 122 */ YY_NOT_ACCEPT,
		/* 123 */ YY_NOT_ACCEPT,
		/* 124 */ YY_NOT_ACCEPT,
		/* 125 */ YY_NOT_ACCEPT,
		/* 126 */ YY_NOT_ACCEPT,
		/* 127 */ YY_NOT_ACCEPT,
		/* 128 */ YY_NOT_ACCEPT,
		/* 129 */ YY_NOT_ACCEPT,
		/* 130 */ YY_NOT_ACCEPT,
		/* 131 */ YY_NOT_ACCEPT,
		/* 132 */ YY_NOT_ACCEPT,
		/* 133 */ YY_NOT_ACCEPT,
		/* 134 */ YY_NOT_ACCEPT,
		/* 135 */ YY_NOT_ACCEPT,
		/* 136 */ YY_NOT_ACCEPT,
		/* 137 */ YY_NOT_ACCEPT,
		/* 138 */ YY_NOT_ACCEPT,
		/* 139 */ YY_NOT_ACCEPT,
		/* 140 */ YY_NOT_ACCEPT,
		/* 141 */ YY_NOT_ACCEPT,
		/* 142 */ YY_NOT_ACCEPT,
		/* 143 */ YY_NOT_ACCEPT,
		/* 144 */ YY_NOT_ACCEPT,
		/* 145 */ YY_NOT_ACCEPT,
		/* 146 */ YY_NOT_ACCEPT,
		/* 147 */ YY_NOT_ACCEPT,
		/* 148 */ YY_NOT_ACCEPT,
		/* 149 */ YY_NOT_ACCEPT,
		/* 150 */ YY_NOT_ACCEPT,
		/* 151 */ YY_NOT_ACCEPT,
		/* 152 */ YY_NOT_ACCEPT,
		/* 153 */ YY_NOT_ACCEPT,
		/* 154 */ YY_NOT_ACCEPT,
		/* 155 */ YY_NOT_ACCEPT,
		/* 156 */ YY_NOT_ACCEPT,
		/* 157 */ YY_NOT_ACCEPT,
		/* 158 */ YY_NOT_ACCEPT,
		/* 159 */ YY_NOT_ACCEPT,
		/* 160 */ YY_NOT_ACCEPT,
		/* 161 */ YY_NOT_ACCEPT,
		/* 162 */ YY_NOT_ACCEPT,
		/* 163 */ YY_NOT_ACCEPT,
		/* 164 */ YY_NOT_ACCEPT,
		/* 165 */ YY_NOT_ACCEPT,
		/* 166 */ YY_NOT_ACCEPT,
		/* 167 */ YY_NOT_ACCEPT,
		/* 168 */ YY_NOT_ACCEPT,
		/* 169 */ YY_NOT_ACCEPT,
		/* 170 */ YY_NOT_ACCEPT,
		/* 171 */ YY_NOT_ACCEPT,
		/* 172 */ YY_NOT_ACCEPT,
		/* 173 */ YY_NOT_ACCEPT,
		/* 174 */ YY_NOT_ACCEPT,
		/* 175 */ YY_NOT_ACCEPT,
		/* 176 */ YY_NOT_ACCEPT,
		/* 177 */ YY_NOT_ACCEPT,
		/* 178 */ YY_NOT_ACCEPT,
		/* 179 */ YY_NOT_ACCEPT,
		/* 180 */ YY_NOT_ACCEPT,
		/* 181 */ YY_NOT_ACCEPT,
		/* 182 */ YY_NOT_ACCEPT,
		/* 183 */ YY_NOT_ACCEPT,
		/* 184 */ YY_NOT_ACCEPT,
		/* 185 */ YY_NOT_ACCEPT,
		/* 186 */ YY_NOT_ACCEPT,
		/* 187 */ YY_NOT_ACCEPT,
		/* 188 */ YY_NOT_ACCEPT,
		/* 189 */ YY_NOT_ACCEPT,
		/* 190 */ YY_NOT_ACCEPT,
		/* 191 */ YY_NOT_ACCEPT,
		/* 192 */ YY_NOT_ACCEPT,
		/* 193 */ YY_NOT_ACCEPT,
		/* 194 */ YY_NOT_ACCEPT,
		/* 195 */ YY_NOT_ACCEPT,
		/* 196 */ YY_NOT_ACCEPT,
		/* 197 */ YY_NOT_ACCEPT,
		/* 198 */ YY_NOT_ACCEPT,
		/* 199 */ YY_NOT_ACCEPT,
		/* 200 */ YY_NOT_ACCEPT,
		/* 201 */ YY_NOT_ACCEPT,
		/* 202 */ YY_NOT_ACCEPT,
		/* 203 */ YY_NOT_ACCEPT,
		/* 204 */ YY_NOT_ACCEPT,
		/* 205 */ YY_NOT_ACCEPT,
		/* 206 */ YY_NOT_ACCEPT,
		/* 207 */ YY_NOT_ACCEPT,
		/* 208 */ YY_NOT_ACCEPT,
		/* 209 */ YY_NOT_ACCEPT,
		/* 210 */ YY_NOT_ACCEPT,
		/* 211 */ YY_NOT_ACCEPT,
		/* 212 */ YY_NOT_ACCEPT,
		/* 213 */ YY_NOT_ACCEPT,
		/* 214 */ YY_NOT_ACCEPT,
		/* 215 */ YY_NOT_ACCEPT,
		/* 216 */ YY_NOT_ACCEPT,
		/* 217 */ YY_NOT_ACCEPT,
		/* 218 */ YY_NOT_ACCEPT,
		/* 219 */ YY_NOT_ACCEPT,
		/* 220 */ YY_NOT_ACCEPT,
		/* 221 */ YY_NOT_ACCEPT,
		/* 222 */ YY_NOT_ACCEPT,
		/* 223 */ YY_NOT_ACCEPT,
		/* 224 */ YY_NOT_ACCEPT,
		/* 225 */ YY_NOT_ACCEPT,
		/* 226 */ YY_NOT_ACCEPT,
		/* 227 */ YY_NOT_ACCEPT,
		/* 228 */ YY_NOT_ACCEPT,
		/* 229 */ YY_NOT_ACCEPT,
		/* 230 */ YY_NOT_ACCEPT,
		/* 231 */ YY_NOT_ACCEPT,
		/* 232 */ YY_NOT_ACCEPT,
		/* 233 */ YY_NOT_ACCEPT,
		/* 234 */ YY_NOT_ACCEPT,
		/* 235 */ YY_NOT_ACCEPT,
		/* 236 */ YY_NOT_ACCEPT,
		/* 237 */ YY_NOT_ACCEPT,
		/* 238 */ YY_NOT_ACCEPT,
		/* 239 */ YY_NOT_ACCEPT,
		/* 240 */ YY_NOT_ACCEPT,
		/* 241 */ YY_NOT_ACCEPT,
		/* 242 */ YY_NOT_ACCEPT,
		/* 243 */ YY_NOT_ACCEPT,
		/* 244 */ YY_NOT_ACCEPT,
		/* 245 */ YY_NOT_ACCEPT,
		/* 246 */ YY_NOT_ACCEPT,
		/* 247 */ YY_NOT_ACCEPT,
		/* 248 */ YY_NOT_ACCEPT,
		/* 249 */ YY_NOT_ACCEPT,
		/* 250 */ YY_NOT_ACCEPT,
		/* 251 */ YY_NOT_ACCEPT,
		/* 252 */ YY_NOT_ACCEPT,
		/* 253 */ YY_NO_ANCHOR,
		/* 254 */ YY_NO_ANCHOR,
		/* 255 */ YY_NOT_ACCEPT,
		/* 256 */ YY_NOT_ACCEPT,
		/* 257 */ YY_NOT_ACCEPT,
		/* 258 */ YY_NOT_ACCEPT,
		/* 259 */ YY_NOT_ACCEPT,
		/* 260 */ YY_NOT_ACCEPT,
		/* 261 */ YY_NOT_ACCEPT,
		/* 262 */ YY_NOT_ACCEPT,
		/* 263 */ YY_NOT_ACCEPT,
		/* 264 */ YY_NOT_ACCEPT,
		/* 265 */ YY_NOT_ACCEPT,
		/* 266 */ YY_NOT_ACCEPT,
		/* 267 */ YY_NOT_ACCEPT,
		/* 268 */ YY_NOT_ACCEPT,
		/* 269 */ YY_NOT_ACCEPT,
		/* 270 */ YY_NOT_ACCEPT,
		/* 271 */ YY_NOT_ACCEPT,
		/* 272 */ YY_NOT_ACCEPT,
		/* 273 */ YY_NOT_ACCEPT,
		/* 274 */ YY_NOT_ACCEPT,
		/* 275 */ YY_NOT_ACCEPT,
		/* 276 */ YY_NOT_ACCEPT,
		/* 277 */ YY_NOT_ACCEPT,
		/* 278 */ YY_NOT_ACCEPT,
		/* 279 */ YY_NOT_ACCEPT,
		/* 280 */ YY_NOT_ACCEPT,
		/* 281 */ YY_NOT_ACCEPT,
		/* 282 */ YY_NOT_ACCEPT,
		/* 283 */ YY_NOT_ACCEPT,
		/* 284 */ YY_NOT_ACCEPT,
		/* 285 */ YY_NOT_ACCEPT,
		/* 286 */ YY_NOT_ACCEPT,
		/* 287 */ YY_NOT_ACCEPT,
		/* 288 */ YY_NOT_ACCEPT,
		/* 289 */ YY_NOT_ACCEPT,
		/* 290 */ YY_NOT_ACCEPT,
		/* 291 */ YY_NOT_ACCEPT,
		/* 292 */ YY_NOT_ACCEPT,
		/* 293 */ YY_NOT_ACCEPT,
		/* 294 */ YY_NOT_ACCEPT,
		/* 295 */ YY_NOT_ACCEPT,
		/* 296 */ YY_NO_ANCHOR,
		/* 297 */ YY_NO_ANCHOR,
		/* 298 */ YY_NOT_ACCEPT,
		/* 299 */ YY_NOT_ACCEPT,
		/* 300 */ YY_NOT_ACCEPT,
		/* 301 */ YY_NOT_ACCEPT,
		/* 302 */ YY_NOT_ACCEPT,
		/* 303 */ YY_NOT_ACCEPT,
		/* 304 */ YY_NOT_ACCEPT,
		/* 305 */ YY_NOT_ACCEPT,
		/* 306 */ YY_NOT_ACCEPT,
		/* 307 */ YY_NOT_ACCEPT,
		/* 308 */ YY_NOT_ACCEPT,
		/* 309 */ YY_NOT_ACCEPT,
		/* 310 */ YY_NOT_ACCEPT,
		/* 311 */ YY_NOT_ACCEPT,
		/* 312 */ YY_NOT_ACCEPT,
		/* 313 */ YY_NOT_ACCEPT,
		/* 314 */ YY_NOT_ACCEPT,
		/* 315 */ YY_NO_ANCHOR,
		/* 316 */ YY_NOT_ACCEPT,
		/* 317 */ YY_NOT_ACCEPT,
		/* 318 */ YY_NOT_ACCEPT,
		/* 319 */ YY_NOT_ACCEPT,
		/* 320 */ YY_NOT_ACCEPT,
		/* 321 */ YY_NOT_ACCEPT,
		/* 322 */ YY_NOT_ACCEPT,
		/* 323 */ YY_NOT_ACCEPT,
		/* 324 */ YY_NOT_ACCEPT,
		/* 325 */ YY_NOT_ACCEPT,
		/* 326 */ YY_NOT_ACCEPT,
		/* 327 */ YY_NOT_ACCEPT,
		/* 328 */ YY_NOT_ACCEPT,
		/* 329 */ YY_NOT_ACCEPT,
		/* 330 */ YY_NOT_ACCEPT,
		/* 331 */ YY_NOT_ACCEPT,
		/* 332 */ YY_NOT_ACCEPT,
		/* 333 */ YY_NOT_ACCEPT,
		/* 334 */ YY_NOT_ACCEPT,
		/* 335 */ YY_NOT_ACCEPT,
		/* 336 */ YY_NOT_ACCEPT
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"48:9,1:2,48:2,1,48:18,1,48,29,48:4,28,48:2,47:2,2,47:2,25,40:2,27:8,48:2,5," +
"47,11,48:2,30,26,33,43,46,36,26:2,34,26:3,45,26:2,32,26:2,38,44,26,37,26:4," +
"3,48,4,48:3,12,18,13,7,8,26,22,23,6,26,39,31,15,9,14,20,26,21,17,10,16,24,2" +
"6,35,42,19,48,41,48:65411,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,337,
"0,1:4,2,3,4,1:41,5,1:4,6,1:4,7,1:2,8,1:3,9,10,11,12,13,1:2,14,15,16,17,18,1" +
"9,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,4" +
"4,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,6" +
"9,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,9" +
"4,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,11" +
"4,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,1" +
"33,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151," +
"152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170" +
",171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,18" +
"9,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,2" +
"08,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226," +
"227,228,229,230,231,232,149,233,234,235,236,237,238,239,240,241,242,243,244" +
",245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,26" +
"3,264,265,266,267,268,269,270,271,272,273,274,275,276")[0];

	private int yy_nxt[][] = unpackFromString(277,49,
"1,2,3,4:2,67,5:5,4,5:13,4,5,6,74,79,5:10,68,7,5:5,4:2,-1:55,5:5,-1,5:13,-1," +
"5:2,-1:2,5:11,-1,5:5,-1:20,8,-1:8,75,-1:12,75,-1:43,69,-1:4,7:2,-1:13,49:5," +
"-1,49:13,-1,49,-1:3,49:10,-1:2,49:5,-1:8,71:5,-1,71:13,-1,71,-1:3,71:10,-1:" +
"2,71:5,-1:8,72:5,-1,72:13,-1,72,-1:3,72:10,-1:2,72:5,-1:4,246,-1:3,246:5,-1" +
",246:16,-1:2,246:11,-1,246:6,-1:8,256,-1,98,-1:45,66,73,-1,78,-1:3,83,86,-1" +
",88,89,90,-1:2,91,92,-1:2,93,-1:41,8,-1:8,75,-1:7,69,-1:4,80,7,-1:42,69,-1:" +
"6,76,-1:31,220,-1:31,99,-1:3,298,-1:42,94:5,-1,94:13,-1,94,-1:3,94:10,-1:2," +
"94:5,-1:20,8,-1:6,114,-1,85,-1:12,85,-1:27,81,-1:22,76,-1:50,238,-1:16,100," +
"-1:66,95,-1,324,-1,96,-1,97,-1,255,-1:28,8,-1:6,114,-1,85,-1:7,69,-1:4,87,7" +
",-1:26,81,-1:74,55,-1:17,258,-1:59,228,-1:41,8,-1:8,85,-1:12,85,-1:24,316,-" +
"1:3,101,-1:46,8,-1:8,85,-1:7,69,-1:4,87,7,-1:24,299,-1:2,102,-1:38,103,-1:4" +
"4,104,-1,105,-1:48,106,-1:61,261,-1:33,107,108,-1,109,-1:6,110,262,111,-1:2" +
",112,113,-1:32,115:5,-1,115:13,-1,115,-1,9,-1,115:10,-1:2,115:5,-1:15,259,-" +
"1:17,257,-1:26,260,-1:70,263,-1:28,10,-1:5,117,-1:48,300,-1:46,303,-1:46,31" +
"7,-1:42,121,-1:55,265,-1:44,122,-1:61,318,-1:47,123,-1:33,319,-1,267,-1:47," +
"305,-1:3,125,-1:48,325,-1:53,323,-1:2,126,-1:34,269,-1:50,128,-1:61,271,-1:" +
"54,266,-1:12,266,-1:36,9,-1:29,306,-1:48,321,-1,11,-1:6,132,-1:45,273,-1:44" +
",12,-1:48,13,-1:48,14,-1:54,275,-1:37,138,-1:11,335,-1:46,139,-1:42,308,-1:" +
"45,143,-1:55,276,-1:56,144,-1:58,279,-1:24,148,-1:53,150,-1:41,153,-1:63,15" +
"4,-1:38,15,-1:48,16,-1:49,156,-1:60,158,-1:41,280,-1:51,159,-1:37,310,-1:48" +
",160,-1,17,-1:6,161,-1:41,18,-1:48,19,-1:43,282,-1:11,336,-1:46,166,-1:57,3" +
"04,-1:38,167,-1:68,168,-1:50,281,-1:50,169,-1:20,20,-1:48,21,-1:47,170,-1:4" +
"9,22,-1:45,172,-1:62,173,-1:45,288,-1:40,23,-1:48,24,-1:54,175,-1:37,287,-1" +
":63,176,-1:38,25,-1:48,26,-1:49,177,-1:56,179,-1:44,180,-1:61,27,-1:51,183," +
"-1:29,289,-1:45,184,-1:49,28,-1:45,185,-1:51,29,-1:48,30,-1:48,31,-1:59,189" +
",-1:45,290,-1:40,32,-1:68,190,-1:37,313,-1:43,191,-1:47,193,-1:45,33,-1:48," +
"34,-1:48,35,-1:58,195,-1:40,196,-1:43,197,-1:52,291,-1:68,202,-1:26,292,-1:" +
"44,203,-1:49,204,-1:52,36,-1:5,205,-1:45,206,-1:45,37,-1:48,38,-1:58,207,-1" +
":54,39,-1:12,39,-1:25,209,-1:64,168,-1:24,211,-1:47,212,-1:51,40,-1:44,214," +
"-1:52,41,-1:5,215,-1:45,210,-1:42,168,-1:61,168,-1:37,216,-1:49,42,-1:48,43" +
",-1:45,217,-1:51,44,-1:45,210,-1:51,45,-1:48,46,-1:37,1,2,47:3,70,47:43,-1:" +
"13,221,-1:49,222,-1:49,295,-1:41,224,-1:49,225,-1:49,226,-1:49,48,-1:37,1,2" +
",4:3,84,49:5,4,49:13,4,49,4:3,49:10,4:2,49:5,4:2,-1:14,229,-1:54,230,-1:41," +
"231,-1:49,232,-1:41,233,-1:49,234,-1:51,50,-1:37,1,2,51,52,53,254,54:5,4,54" +
":13,4,54,4:3,54:10,4:2,54,253,54,296,54,4:2,-1:6,237,-1:51,239,-1:69,55,-1:" +
"29,56,-1:37,1,2,4,57,58,297,59:5,4,59:13,4,59,4:3,59:10,4:2,59:5,4:2,-1:14," +
"242,-1:50,243,-1:42,244,-1:49,60,-1:37,1,2,61,62,63,315,4:43,-1:2,246,-1,64" +
",-1,246:5,-1,246:16,-1:2,246:11,-1,246:6,-1:19,248,-1:38,249,-1:63,250,-1:3" +
"7,251,-1:60,252,-1:35,65,-1:43,71:5,-1,71:13,-1,71,-1:3,77,71:9,-1:2,71:5,-" +
"1:27,236,-1:33,302,-1:46,116,-1:71,129,-1:32,118,-1:46,268,-1:42,130,-1:55," +
"124,-1:44,127,-1:50,307,-1:44,134,-1:61,136,-1:54,146,-1:12,146,-1:25,141,-" +
"1:47,147,-1:42,277,-1:45,155,-1:55,145,-1:56,309,-1:34,278,-1:53,162,-1:41," +
"157,-1:63,165,-1:44,283,-1:40,171,-1:55,284,-1:42,312,-1:46,286,-1:57,311,-" +
"1:37,178,-1:63,181,-1:39,182,-1:49,192,-1:45,188,-1:46,186,-1:54,194,-1:42," +
"198,-1:50,208,-1:46,213,-1:48,218,-1:55,223,-1:39,71:5,-1,71:13,-1,71,-1:3," +
"71:10,-1:2,71:4,82,-1:27,241,-1:33,264,-1:46,120,-1:53,133,-1:49,272,-1:46," +
"131,-1:44,135,-1:67,329,-1:12,329,-1:25,274,-1:41,151,-1:60,149,-1:34,163,-" +
"1:61,285,-1:37,174,-1:48,314,-1:46,187,-1:54,201,-1:42,199,-1:65,247,-1:33," +
"119,-1:52,270,-1:46,137,-1:44,140,-1:67,200,-1:12,200,-1:25,152,-1:39,164,-" +
"1:48,142,-1:61,301,-1:42,322,-1:40,293,-1:48,294,-1:55,326,-1:61,320,-1:12," +
"320,-1:21,328,-1:49,327,-1:44,330,-1:51,331,-1:45,333,-1:44,332,-1:48,334,-" +
"1:42");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{/*No hace nada, hay que obviarlo*/ }
					case -3:
						break;
					case 3:
						{/*Palabra reservada*/ return new Symbol(sym.COMA, (yyline+1), yychar);}
					case -4:
						break;
					case 4:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.IDENT, (yyline+1), yychar, yytext());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
					case -7:
						break;
					case 7:
						{return new Symbol(sym.INSBITCODE, (yyline+1), yychar, yytext());}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.REGBITCODE, (yyline+1), yychar, yytext());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.NAME, (yyline+1), yychar, yytext());}
					case -10:
						break;
					case 10:
						{/*Palabra reservada*/yybegin(IN); return new Symbol(sym.APERTURAIN, (yyline+1), yychar);}
					case -11:
						break;
					case 11:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAINS, (yyline+1), yychar);}
					case -12:
						break;
					case 12:
						{/*Palabra reservada*/yybegin(OUT); return new Symbol(sym.APERTURAOUT, (yyline+1), yychar);}
					case -13:
						break;
					case 13:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAUSE, (yyline+1), yychar);}
					case -14:
						break;
					case 14:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAUPD, (yyline+1), yychar);}
					case -15:
						break;
					case 15:
						{/*Palabra reservada*/return new Symbol(sym.APERTURADATE, (yyline+1), yychar);}
					case -16:
						break;
					case 16:
						{/*Palabra reservada*/return new Symbol(sym.APERTURANAME, (yyline+1), yychar);}
					case -17:
						break;
					case 17:
						{/*Palabra reservada*/return new Symbol(sym.CIERREINS, (yyline+1), yychar);}
					case -18:
						break;
					case 18:
						{/*Palabra reservada*/return new Symbol(sym.CIERREUSE, (yyline+1), yychar);}
					case -19:
						break;
					case 19:
						{/*Palabra reservada*/return new Symbol(sym.CIERREUPD, (yyline+1), yychar);}
					case -20:
						break;
					case 20:
						{/*Palabra reservada*/ return new Symbol(sym.APERTURAIDENT, (yyline+1), yychar);}
					case -21:
						break;
					case 21:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAINSNS, (yyline+1), yychar);}
					case -22:
						break;
					case 22:
						{/*Palabra reservada*/return new Symbol(sym.APERTURADESCR, (yyline+1), yychar);}
					case -23:
						break;
					case 23:
						{/*Palabra reservada*/yybegin(BEHAV); return new Symbol(sym.APERTURABEHAV, (yyline+1), yychar);}
					case -24:
						break;
					case 24:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAGROUP, (yyline+1), yychar);}
					case -25:
						break;
					case 25:
						{/*Palabra reservada*/return new Symbol(sym.CIERREDATE, (yyline+1), yychar);}
					case -26:
						break;
					case 26:
						{/*Palabra reservada*/return new Symbol(sym.CIERRENAME, (yyline+1), yychar);}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.USE, (yyline+1), yychar, yytext());}
					case -28:
						break;
					case 28:
						{/*Palabra reservada*/yybegin(OPCODE); return new Symbol(sym.APERTURAOPCODE, (yyline+1), yychar);}
					case -29:
						break;
					case 29:
						{/*Palabra reservada*/ return new Symbol(sym.CIERREIDENT, (yyline+1), yychar);}
					case -30:
						break;
					case 30:
						{/*Palabra reservada*/return new Symbol(sym.CIERREINSNS, (yyline+1), yychar);}
					case -31:
						break;
					case 31:
						{/*Palabra reservada*/return new Symbol(sym.CIERREDESCR, (yyline+1), yychar);}
					case -32:
						break;
					case 32:
						{/*Palabra reservada*/return new Symbol(sym.CIERREGROUP, (yyline+1), yychar);}
					case -33:
						break;
					case 33:
						{/*Palabra reservada, entra en el estado COMMENT*/yybegin(COMMENT);}
					case -34:
						break;
					case 34:
						{/*Palabra reservada*/return new Symbol(sym.APERTURASTORAGE, (yyline+1), yychar);}
					case -35:
						break;
					case 35:
						{/*Palabra reservada*/return new Symbol(sym.APERTURABITSIZE, (yyline+1), yychar);}
					case -36:
						break;
					case 36:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAREGISTER, (yyline+1), yychar);}
					case -37:
						break;
					case 37:
						{/*Palabra reservada*/return new Symbol(sym.CIERRESTORAGE, (yyline+1), yychar);}
					case -38:
						break;
					case 38:
						{/*Palabra reservada*/return new Symbol(sym.CIERREBITSIZE, (yyline+1), yychar);}
					case -39:
						break;
					case 39:
						{return new Symbol(sym.DATE, (yyline+1), yychar, yytext());}
					case -40:
						break;
					case 40:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAREGISTERS, (yyline+1), yychar);}
					case -41:
						break;
					case 41:
						{/*Palabra reservada*/return new Symbol(sym.CIERREREGISTER, (yyline+1), yychar);}
					case -42:
						break;
					case 42:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAINSBITCODE, (yyline+1), yychar);}
					case -43:
						break;
					case 43:
						{/*Palabra reservada*/return new Symbol(sym.APERTURAREGBITCODE, (yyline+1), yychar);}
					case -44:
						break;
					case 44:
						{/*Palabra reservada*/return new Symbol(sym.CIERREREGISTERS, (yyline+1), yychar);}
					case -45:
						break;
					case 45:
						{/*Palabra reservada*/return new Symbol(sym.CIERREINSBITCODE, (yyline+1), yychar);}
					case -46:
						break;
					case 46:
						{/*Palabra reservada*/return new Symbol(sym.CIERREREGBITCODE, (yyline+1), yychar);}
					case -47:
						break;
					case 47:
						{/*No se hace nada, se obvia*/}
					case -48:
						break;
					case 48:
						{}
					case -49:
						break;
					case 49:
						{return new Symbol(sym.CODIGOOPERACION, (yyline+1), yychar, yytext());}
					case -50:
						break;
					case 50:
						{/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREOPCODE, (yyline+1), yychar); }
					case -51:
						break;
					case 51:
						{/*Palabra reservada*/ return new Symbol(sym.COMA, (yyline+1), yychar);}
					case -52:
						break;
					case 52:
						{/*Palabra reservada*/ return new Symbol(sym.ABRECORCHETE, (yyline+1), yychar);}
					case -53:
						break;
					case 53:
						{/*Palabra reservada*/ return new Symbol(sym.CIERRACORCHETE, (yyline+1), yychar);}
					case -54:
						break;
					case 54:
						{return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
					case -55:
						break;
					case 55:
						{return new Symbol(sym.DATAMEM, (yyline+1), yychar, yytext());}
					case -56:
						break;
					case 56:
						{/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREIN, (yyline+1), yychar); }
					case -57:
						break;
					case 57:
						{/*Palabra reservada*/ return new Symbol(sym.ABRECORCHETE, (yyline+1), yychar);}
					case -58:
						break;
					case 58:
						{/*Palabra reservada*/ return new Symbol(sym.CIERRACORCHETE, (yyline+1), yychar);}
					case -59:
						break;
					case 59:
						{return new Symbol(sym.NOMBREOPERANDOOUT, (yyline+1), yychar, yytext());}
					case -60:
						break;
					case 60:
						{/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREOUT, (yyline+1), yychar); }
					case -61:
						break;
					case 61:
						{/*Palabra reservada*/ return new Symbol(sym.COMA, (yyline+1), yychar);}
					case -62:
						break;
					case 62:
						{/*Palabra reservada*/ return new Symbol(sym.ABRECORCHETE, (yyline+1), yychar);}
					case -63:
						break;
					case 63:
						{/*Palabra reservada*/ return new Symbol(sym.CIERRACORCHETE, (yyline+1), yychar);}
					case -64:
						break;
					case 64:
						{return new Symbol(sym.BEHAV, (yyline+1), yychar, yytext());}
					case -65:
						break;
					case 65:
						{/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREBEHAV, (yyline+1), yychar); }
					case -66:
						break;
					case 67:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -67:
						break;
					case 68:
						{return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
					case -68:
						break;
					case 69:
						{return new Symbol(sym.INSBITCODE, (yyline+1), yychar, yytext());}
					case -69:
						break;
					case 70:
						{/*No se hace nada, se obvia*/}
					case -70:
						break;
					case 71:
						{return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
					case -71:
						break;
					case 72:
						{return new Symbol(sym.NOMBREOPERANDOOUT, (yyline+1), yychar, yytext());}
					case -72:
						break;
					case 74:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -73:
						break;
					case 75:
						{return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
					case -74:
						break;
					case 76:
						{return new Symbol(sym.INSBITCODE, (yyline+1), yychar, yytext());}
					case -75:
						break;
					case 77:
						{return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
					case -76:
						break;
					case 79:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -77:
						break;
					case 80:
						{return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
					case -78:
						break;
					case 81:
						{return new Symbol(sym.INSBITCODE, (yyline+1), yychar, yytext());}
					case -79:
						break;
					case 82:
						{return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
					case -80:
						break;
					case 84:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -81:
						break;
					case 85:
						{return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
					case -82:
						break;
					case 87:
						{return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
					case -83:
						break;
					case 253:
						{return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
					case -84:
						break;
					case 254:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -85:
						break;
					case 296:
						{return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
					case -86:
						break;
					case 297:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -87:
						break;
					case 315:
						{ System.out.println("Error lexico!!!: "+yytext());}
					case -88:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
