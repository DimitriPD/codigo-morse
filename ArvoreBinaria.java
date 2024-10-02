class ArvoreBinaria {
    private Node root;

    public ArvoreBinaria() {
        this.root = new Node("             ", "ROOT");
        this.popularArvore();
    }

    public Node getRoot() {
        return root;
    }

    public void insert(String sequence, String letter) {
        Node newNode = new Node(sequence, letter);
        Node currentNode = this.root;
        recursiveInsert(currentNode, newNode, 0);
    }

    private void recursiveInsert(Node currentNode, Node newNode, int iterator) {
        char symbol = newNode.getSequence().charAt(iterator);
        switch (symbol) {
            case '.':
                if (currentNode.getLeftNode() != null) {
                    recursiveInsert(currentNode.getLeftNode(), newNode, iterator + 1);
                } else {
                    currentNode.setLeftNode(newNode);
                }
                break;
        
            case '-':
                if (currentNode.getRightNode() != null) {
                    recursiveInsert(currentNode.getRightNode(), newNode, iterator + 1);
                } else {
                    currentNode.setRightNode(newNode);
                }
                break;
        }
    }

    private String morseToChar(Node currentNode, String sequence, int iterator) {
        if (iterator == sequence.length()) {
            return currentNode.getLetter();
        }
        
        char symbol = sequence.charAt(iterator);
        if (symbol == '.') {
            return morseToChar(currentNode.getLeftNode(), sequence, iterator + 1);
        } else if (symbol == '-') {
            return morseToChar(currentNode.getRightNode(), sequence, iterator + 1);
        }
        return "";
    }

    private String charToMorse(Node currentNode, String letter) {
        if (currentNode != null) {
            String result = charToMorse(currentNode.getLeftNode(), letter);
            if (!result.isEmpty()) {
                return result; 
            }
    
            if (currentNode.getLetter().toUpperCase().equals(letter.toUpperCase())) {
                return currentNode.getSequence();
            }
    
            result = charToMorse(currentNode.getRightNode(), letter);
            if (!result.isEmpty()) {
                return result; 
            }
        }
        return ""; 
    }
    
    public String decodeMorse(String morseMessage) {
        String decoded = "";
        String[] sequences = morseMessage.split(" ");

        for (String sequence : sequences) {
            if (sequence.equals("/")) {
                decoded += " ";
            } else {
                decoded += this.morseToChar(this.root, sequence, 0);
            }
        }

        return decoded;
    }

    public String encodeMorse(String word) {
        String encoded = "";

        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            if (letter.equals(" ")) {
                encoded += "/ ";
            } else {
                encoded += this.charToMorse(this.root, letter) + " ";
            }
        }
        return encoded;
    }

    public void printTree() {
        printTreeRec(root, 0);
    }
    
    private void printTreeRec(Node currentNode, int nivel) {
        if (currentNode == null) {
            return;
        }
    
        printTreeRec(currentNode.getRightNode(), nivel + 1);
    
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); 
        }
        System.out.println(currentNode.getLetter());
    
        printTreeRec(currentNode.getLeftNode(), nivel + 1);
    }
 
    private void popularArvore() {
        this.insert(".", "E");
        this.insert("-", "T");

        this.insert("..", "I");
        this.insert(".-", "A");
        this.insert("-.", "N");
        this.insert("--", "M");
        
        this.insert("...", "S");
        this.insert("..-", "U");
        this.insert(".-.", "R");
        this.insert(".--", "W");
        this.insert("-..", "D");
        this.insert("-.-", "K");
        this.insert("--.", "G");
        this.insert("---", "O");

        this.insert("....", "H");
        this.insert("...-", "V");
        this.insert("..-.", "F");
        this.insert(".-..", "L");
        this.insert(".--.", "P");
        this.insert(".---", "J");
        this.insert("-...", "B");
        this.insert("-..-", "X");
        this.insert("-.-.", "C");
        this.insert("-.--", "Y");
        this.insert("--..", "Z");
        this.insert("--.-", "Q");
    }
}