# roman-calculator-java
Roman calculator using java with steps

## Usage/Examples
### Roman Value
U need to initialize value for Roman numbers.
```javascript
static int nilaiRomawi(char r)
	{
	    if (r == 'I')
	        return 1;
	 
	    if (r == 'V')
	        return 5;
	 
	    if (r == 'X')
	        return 10;
	 
	    if (r == 'L')
	        return 50;
	 
	    if (r == 'C')
	        return 100;
	 
	    if (r == 'D')
	        return 500;
	 
	    if (r == 'M')
	        return 1000;
	 
	    return -1;
	}
```