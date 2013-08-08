/*
 * Copyright: (c) 2009   Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package edu.mayo.bmi.fsm.token.adapter;

import java.util.ArrayList;
import java.util.List;

import edu.mayo.bmi.fsm.token.BaseToken;
import edu.mayo.bmi.fsm.token.DecimalToken;
import edu.mayo.bmi.fsm.token.IntegerToken;
import edu.mayo.bmi.fsm.token.PunctuationToken;
import edu.mayo.bmi.fsm.token.WordToken;
import edu.mayo.bmi.nlp.tokenizer.Token;

public class TokenConverter {

	public static List<BaseToken> convertTokens(List<Token> tokens) {
		List<BaseToken> baseTokens = new ArrayList<BaseToken>();

		for (int i = 0; i < tokens.size(); i++) {
			Token t = (Token) tokens.get(i);
			switch (t.getType()) {
			case Token.TYPE_WORD:
				WordToken wt = new WordTokenAdapter(t);
				baseTokens.add(wt);
				break;
			case Token.TYPE_PUNCT:
				PunctuationToken pt = new PunctuationTokenAdapter(t);
				baseTokens.add(pt);
				break;
			case Token.TYPE_NUMBER:
				if (t.isInteger()) {
					IntegerToken it = new IntegerTokenAdapter(t);
					baseTokens.add(it);
				} else {
					DecimalToken dt = new DecimalTokenAdapter(t);
					baseTokens.add(dt);
				}
				break;
			case Token.TYPE_EOL:
				break;
			case Token.TYPE_CONTRACTION:
				break;
			}
		}

		return baseTokens;
	}

}
