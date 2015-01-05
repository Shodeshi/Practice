def findRoot(parentList, data):
	parent=parentList[data];
	prev=data;
	while(parent>0 and parentList[parent]>0):	
		parentList[prev]=parentList[parent];	
		prev=parent;
		parent=parentList[parent];		
	if(parent==0):
		return data;
	else:
		return parent;
		
length=int(raw_input());
componentCount=length;
parentList=[0]*(length + 1);

input=raw_input();
while(input != "S"):
	inputList=input.split();
	a=int(inputList[1]);
	b=int(inputList[2]);
	rootA=findRoot(parentList, a);
	rootB=findRoot(parentList, b);
	if("C" == inputList[0]):
		if(rootA == rootB):
			print "yes";
		else:
			print "no";
	elif("I" == inputList[0]):
		if(rootA != rootB):
			if(parentList[rootB] == 0):
				componentCount -= 1;
			parentList[rootB] = rootA;
			
	input=raw_input();

if(componentCount == 1):
	print "The network is connected.";
else:
	print "There are",componentCount,"components."