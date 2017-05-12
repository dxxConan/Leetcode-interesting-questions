public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                String firstPart = input.substring(0, i);
                String secondPart = input.substring(i+1);
                List<Integer> firstPartResult = diffWaysToCompute(firstPart);
                List<Integer> secondPartResult = diffWaysToCompute(secondPart);
                //add all possible combinations to result
                for(int first : firstPartResult){
                    for(int second: secondPartResult){
                        if(c == '-'){
                            result.add(first - second);
                        }else if(c == '+'){
                            result.add(first + second);
                        }else if(c == '*'){
                            result.add(first * second);
                        }
                    }
                }
            }
        }
        //only a number without any operation sign
        if (result.size() == 0){
            result.add(Integer.parseInt(input));
        }
        return result;
    }