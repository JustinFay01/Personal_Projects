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

my @search;
my %seen;

my %looking;

#Opens file, deals with errors,
if ( @ARGV != 0 ) {
    if ( @ARGV > 2 ) {
        print("To many commands are present.\n");
        exit;
    }
    elsif ( @ARGV == 2 ) {
        open( FH, $ARGV[0] )
          or die "File $ARGV[0] could not be found or does not exist.\n";

        chomp( @lines = <FH> );
        shift @lines;

        @search = split( "", $ARGV[1] );

        foreach (@search) {
            if ( !( exists $aminohash{$_} ) ) {
                print(
"Invalid search critera, one or more variables are not amino acids.\n"
                );
                exit;
            }

            my %seen;
            foreach my $repeat (@search) {
                next unless $seen{$repeat}++;
                print(
                    "One or more amino acids have been entered twice or more.\n"
                );
                exit;
            }

            push @{ $looking{$_} }, 0;
        }
        close(FH);
    }
    elsif ( @ARGV == 1 ) {
        open( FH, $ARGV[0] )
          or die "File $ARGV[0] could not be found or does not exist.\n";
        chomp( @lines = <FH> );
        shift @lines;
        close(FH);
    }
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

#Print in alphabetical order.
my @empty;
my $different = 0;

#If There is no search critera do what V3 does.
if ( @search == 0 ) {
    foreach my $key ( sort( keys %aminohash ) ) {
        if ( $aminohash{$key} != 0 ) {
            print $key, ' ', $aminohash{$key}, "\n";

            $different++;
        }
        else {
            push( @empty, $key );
        }
    }

    print("\nNumber of different amino acids: $different\n\n");

    #Print the ones that didn't show up
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
    foreach my $value ( sort { $aminohash{$b} <=> $aminohash{$a} }
        ( keys %aminohash ) )
    {
        if ( $aminohash{$value} != 0 ) {
            print( $value, ' ', $aminohash{$value}, "\n" );
        }

    }
}

#If there is a search critera do something new.
else {
    foreach my $key ( sort( keys %aminohash ) ) {
        if ( $aminohash{$key} != 0 ) {
            $different++;
            if ( exists( $looking{$key} ) ) {
                print $key, ' ', $aminohash{$key}, "\n";
            }
        }
        elsif ( exists( $looking{$key} ) && $aminohash{$key} == 0 ) {
            push( @empty, $key );
        }
    }

    print("\nNumber of different amino acids: $different\n\n");

    #Print the ones that didn't show
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

}
