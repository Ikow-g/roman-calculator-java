# roman-calculator-java
Roman calculator using java with steps

:warning:For the process, we can only use string manipulation.:warning:
## Usage/Examples
### Roman Value
You need to initialize value for Roman numbers.
```javascript
static int nilaiRomawi(char r)
	{
	    if (r == 'I') return 1;
	    if (r == 'V') return 5;
	    if (r == 'X') return 10;
	    if (r == 'L') return 50;
	    if (r == 'C') return 100;
	    if (r == 'D') return 500;
	    if (r == 'M') return 1000;

	    return -1;
	}
```

### Important Steps
:warning: Every result from each steps must be saved for the explanation part after the final result.
- Check any substractive notation, if any change it into additive

For example:
```
IV replace it with IIII
IX replace it with VIIII
and so on until CM replace with DCCCC
```

- Combine both inputs and sort them into descending order

Sorting method:
```js
public static ArrayList<romawi> sortArr(String[] arr, int n)
	{
	    ArrayList<romawi> array = new ArrayList<romawi>();
	    for(int i = 0; i < n; i++)
	    {
	    	array.add(new romawi(arr[i],memberiValue(arr[i])));
	    }
	    Compare obj = new Compare();
	    obj.compare(array);
	    return array;
	}
```

- Simplify

The basic is to change every possible notation.
For example:
```js
IIIII replace it with V
XXXXX replace it with L
```
Also in this process, you have to save each changes into array so that we can display them in the steps part.
```js
if(temp2.contains("IIIII")){
	from[indexsimp]="IIIII";//save before change
	to[indexsimp]="V";//save target change
	temp2 = simplify(temp2);
	get[indexsimp] = temp2;//save results
	indexsimp++;det4++;
	temp2 = turn(temp2);
	continue;
}
```
