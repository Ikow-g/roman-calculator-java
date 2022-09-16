# roman-calculator-java
Roman calculator using java with steps

## Usage/Examples
### Roman Value
U need to initialize value for Roman numbers.
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
- Check any substractive notation, if any change it into additive

```
for example: IV replace it with IIII 
```

- Combine both inputs and sort them into descending order

```js
Sorting method:
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