use strict;

my %aminohash = (
    A => 0,
    C => 0,
    D => 0,
    E => 0,
    F => 0,
    G => 0,
    H => 0,
    I => 0,
    K => 0,
    L => 0,
    M => 0,
    N => 0,
    P => 0,
    Q => 0,
    R => 0,
    S => 0,
    T => 0,
    V => 0,
    W => 0,
    Y => 0
);

my @keys   = keys %aminohash;
my @values = values %aminohash;
my @lines;

#Opens file, deals with errors,
if ( @ARGV > 1 ) {
    print("More than one command is present.\n");
    exit;
}
if ( @ARGV != 0 ) {
    open( FH, $ARGV[0] )
      or die "File $ARGV[0] could not be found or does not exist.\n";
    chomp( @lines = <FH> );
    shift @lines;
    close(FH);
}
else {
    print( $ARGV[0] );
    print("No File name was given.\n");
    exit;
}

my @split;
for ( my $i ; $i < $#lines ; $i++ ) {
        push( @split, split( "", $lines[$i] ) );
}

#Adds if word is found.

foreach (@split) {
    if ( exists( $aminohash{$_} ) ) {
        $aminohash{$_}++;
    }
    else {
        print(
"The file contains something other than amino acids. $split[$_ - 1] was found.\n"
        );
        exit;
    }
}

#Testing occurrence returns.

# $aminohash{'A'} = '0';
# $aminohash{'B'} = '0';
# $aminohash{'E'} = '0';
# $aminohash{'V'} = '0';
# $aminohash{'W'} = '2';
# $aminohash{'Y'} = '2';

#Print in alphabetical order.
my @empty;
my $different = 0;
foreach my $key ( sort( keys %aminohash ) ) {
    if ( $aminohash{$key} ) {
        print $key, ' ', $aminohash{$key}, "\n";

        $different++;
    }
    else {
        push( @empty, $key );
    }

}

print("\nNumber of different amino acids: $different\n\n");

if ( @empty != 0 ) {
    if ( @empty == 1 ) {
        print("No occurrences of $empty[$_].\n\n");
    }
    else {
        print("No occurrences of ");
        for ( my $i = 0 ; $i < $#empty ; $i++ ) {
            print("$empty[$i], ");
        }
        print("or $empty[-1].\n\n");
    }

}

#Sort by value
foreach
  my $value ( sort { $aminohash{$b} <=> $aminohash{$a} } ( keys %aminohash ) )
{
    if ( $aminohash{$value} != 0 ) {
        print( $value, ' ', $aminohash{$value}, "\n" );
    }

}

