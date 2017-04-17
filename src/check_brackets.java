import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {

        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        Bracket currentBracket = new Bracket('a',0);
        int answ = 0;

        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                currentBracket.type=next;
                currentBracket.position = position+1;
                opening_brackets_stack.push(currentBracket);
            }

            if (next == ')' || next == ']' || next == '}') {
                currentBracket = opening_brackets_stack.pop();
                if (next == ')' ){
                    if (!currentBracket.Match('(')){
                        answ = position+1;
                        break;

                    }

                }
                    else if (next == ']'){
                    if(!currentBracket.Match('[')){
                        answ = position+1;
                        break;
                    }

                }
                    else{
                    if (!currentBracket.Match('{')) {
                        answ = position + 1;
                        break;
                    }

                }

            }
        }

        if(opening_brackets_stack.empty()) System.out.println("Success");
        else if (answ == 0){
            answ = opening_brackets_stack.peek().position;
            System.out.println(answ);
        }
        else System.out.println(answ);

    }
}
